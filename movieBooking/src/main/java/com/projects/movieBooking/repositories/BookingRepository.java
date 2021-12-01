package com.projects.movieBooking.repositories;

import com.projects.movieBooking.entities.Booking;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.Date;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer>, JpaSpecificationExecutor<Booking> {
    @Modifying
    @Query (value="insert into booking (no_of_seats, time_stamp, status, user_id, show_id) values (:noOfSeats, timestamp(:timeStamp),:status,:userId,:showId)",
        nativeQuery = true
    )
    @Transactional
    public void insertWithQuery(@Param("noOfSeats") Integer noOfSeats, @Param("timeStamp") String timeStamp, @Param("status") Integer status, @Param("userId") Integer userId, @Param("showId") Integer showId);

    @Query (value="select * from booking where show_id = :showId and time_stamp = timestamp(:timeStamp) and user_id = :userId",
        nativeQuery = true
    )
    public List<Booking> getBookingId(@Param("showId") Integer showId, @Param("timeStamp") String timeStamp, @Param("userId") Integer userId);

    @Modifying
    @Query (value="update booking set status = :status where booking_id = :bookingId",
            nativeQuery = true
    )
    @Transactional
    public void updateStatus(@Param("status") Integer status, @Param("bookingId") Integer bookingId);

}