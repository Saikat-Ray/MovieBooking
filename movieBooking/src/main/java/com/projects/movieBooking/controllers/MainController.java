package com.projects.movieBooking.controllers;

import com.google.gson.Gson;
import com.projects.movieBooking.entities.*;
import com.projects.movieBooking.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.repository.init.ResourceReader.Type.JSON;

@Controller
@RequestMapping (path="/home")
public class MainController {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieShowRepository movieShowRepository;
    @Autowired
    private CinemaHallRepository cinemaHallRepository;
    @Autowired
    private CinemaSeatRepository cinemaSeatRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private UserRepository userRepository;

    private int STATUS_BOOKED = 1;
    private int STATUS_AVAILABLE = 0;
    private int STATUS_PAID = 2;

    @GetMapping(path = "/user")
    public String getUser(@RequestParam Integer uValue) {
        System.out.println(uValue);
        String ret="";
        Optional<User> users = userRepository.findById(uValue);
        List<String> userData = new ArrayList<String>();
        if (users.isPresent()){
            User user = users.get();
            userData.add(user.getUserId().toString());
            userData.add(user.getName());
            ret = user.getName();
        }
        return new Gson().toJson(ret);
    }

    @GetMapping(path = "/city")
    public String getAllCities(Model model) {
        model.addAttribute("cityList", cityRepository.findAll());
        model.addAttribute("movieList", movieRepository.findAll());
        model.addAttribute("userName",userRepository.findById(100));
        return "home";
    }

    @GetMapping(path = "/cinema")
    @ResponseBody
    public String getCinemaList(@RequestParam Integer cValue) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(cinemaRepository.findQuery(cValue)));
        return gson.toJson(cinemaRepository.findQuery(cValue));
    }

    @GetMapping(path = "/hall")
    @ResponseBody
    public String getCinemaHall(@RequestParam Integer cinValue) {
        Gson gson = new Gson();
        List<CinemaHall> cinemaHalls = cinemaHallRepository.findHallsQuery(cinValue);
        return gson.toJson(cinemaHalls);
    }

    @GetMapping(path = "/show")
    @ResponseBody
    public String getShowDate(@RequestParam Integer movieValue, @RequestParam Integer cinemaHallValue) {
        Gson gson = new Gson();
        return gson.toJson(movieShowRepository.findShowByMovieAndCinemaQuery(movieValue, cinemaHallValue));
    }

    @GetMapping(path = "/seatsTotal")
    @ResponseBody
    public String getCinemaSeats(@RequestParam Integer cinemaHallId) {
        String ret = cinemaSeatRepository.findTotalSeats(cinemaHallId).toString();
        return new Gson().toJson(ret);
    }

    @GetMapping(path = "/seatsAvailable")
    @ResponseBody
    public String getShowSeats(@RequestParam Integer showId) {
        List<ShowSeat> showSeats = showSeatRepository.findAvailableSeats(showId);
        return new Gson().toJson(showSeats);
    }

    @PostMapping(path = "/bookShow")
    @ResponseBody
    public String submitForm(HttpServletRequest request, HttpServletResponse response, Model model) {
        Date time_stamp = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = simpleDateFormat.format(time_stamp);

        String[] seats = request.getParameter("bookSeatsId").split(",");
        Integer status = Integer.valueOf(STATUS_BOOKED);
        //Integer userId = Integer.parseInt(request.getParameter("userId"));
        Integer userId = Integer.parseInt("100");
        Integer showId = Integer.parseInt(request.getParameter("showDate"));
        Integer noOfSeats = Integer.valueOf(seats.length);

        bookingRepository.insertWithQuery(noOfSeats, dateStr, status, userId, showId);
        List<Booking> bookings = bookingRepository.getBookingId(showId, dateStr.toString(), userId);

        Booking booking;

        List<String> ret = new ArrayList<String>();
        String booking_id = "", booking_amount = "";
        int price = 0;

        for (int i = 0; i < bookings.size(); i++) {
            booking = bookings.get(i);
            booking_id = booking.getBookingId().toString();
            for (int j = 0; j < seats.length; j++) {
                showSeatRepository.reserveShowSeats(Integer.valueOf(seats[j]), booking.getShowId(), booking.getBookingId());
            }
            List<ShowSeat> seatList = showSeatRepository.getSeatPrice(booking.getBookingId());

            for (int k = 0; k < seatList.size(); k++) {
                ShowSeat seatPrice = seatList.get(i);
                price += seatPrice.getPrice();
            }
        }

        ret.add(booking_id);
        ret.add(String.valueOf(price));
        ret.add(dateStr);

        return new Gson().toJson(ret);
    }
    @PostMapping(path = "/makePayment")
    @ResponseBody
    public String submitPaymentForm(HttpServletRequest request, HttpServletResponse response, Model model) {
        String ret = "";
        System.out.println("inside submitPaymentForm");
        Integer bookingId = Integer.valueOf(request.getParameter("bookingId"));
        System.out.println(bookingId.toString());
        Integer totalAmount = Integer.valueOf(request.getParameter("totalAmount"));
        String bookingDate = request.getParameter("bookingDate");
        paymentRepository.insertPayment(totalAmount, bookingDate, 0, bookingId);
        bookingRepository.updateStatus(STATUS_AVAILABLE, bookingId);
        ret = bookingId.toString();
        return new Gson().toJson(ret);
    }

    @PostMapping(path = "/cancelBooking")
    @ResponseBody
    public String cancelBooking(HttpServletRequest request, HttpServletResponse response, Model model) {
        System.out.println("Cancel Booking called...");
        String ret = "";
        Integer bookingId = Integer.parseInt(request.getParameter("bookingId"));
        System.out.println(bookingId);
        showSeatRepository.cancelSeatsByBookingId(bookingId);
        bookingRepository.deleteById(bookingId);
        return new Gson().toJson(ret);
    }
}
