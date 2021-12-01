package com.projects.movieBooking.repositories;

import com.projects.movieBooking.entities.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer>, JpaSpecificationExecutor<ShowSeat> {
    @Query(
            value = "select * from show_seat where show_id = :showId and status = 0",
            nativeQuery = true
    )
    public List<ShowSeat> findAvailableSeats(@Param("showId") Integer showId);

    @Modifying
    @Query(
            value="update show_seat set booking_id = :bookingId, status = 1 where cinema_seat_id = :cinemaSeatId and show_id = :showId",
            nativeQuery = true
    )
    @Transactional
    public void reserveShowSeats(@Param("cinemaSeatId") Integer cinemaSeatId, @Param("showId") Integer showId, @Param("bookingId") Integer bookingId);

    @Modifying
    @Query(
            value="update show_seat set booking_id = null, status = 0 where booking_id = :bookingId",
            nativeQuery = true
    )
    @Transactional
    public void cancelSeatsByBookingId(@Param("bookingId") Integer bookingId);

    @Query(
            value="select * from show_seat where booking_id = :bookingId",
            nativeQuery = true
    )
    public List<ShowSeat> getSeatPrice(@Param("bookingId") Integer bookingId);
}