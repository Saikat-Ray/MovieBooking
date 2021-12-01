package com.projects.movieBooking.controllers;

import com.projects.movieBooking.dto.BookingDTO;
import com.projects.movieBooking.services.BookingService;
import com.projects.movieBooking.viewobjects.BookingQueryVO;
import com.projects.movieBooking.viewobjects.BookingUpdateVO;
import com.projects.movieBooking.viewobjects.BookingVO;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public String save(@RequestBody BookingVO vO) {
        return bookingService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@NotNull @PathVariable("id") Integer id) {
        bookingService.delete(id);
    }

    @PutMapping("/{id}")
    public void update( @NotNull @PathVariable("id") Integer id,
                        @RequestBody BookingUpdateVO vO) {
        bookingService.update(id, vO);
    }

    @GetMapping("/{id}")
    public BookingDTO getById( @NotNull @PathVariable("id") Integer id) {
        return bookingService.getById(id);
    }

    @GetMapping
    public Page<BookingDTO> query( BookingQueryVO vO) {
        return bookingService.query(vO);
    }
}
