package com.projects.movieBooking.repositories;

import com.projects.movieBooking.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface PaymentRepository extends JpaRepository<Payment, Integer>, JpaSpecificationExecutor<Payment> {
    @Modifying
    @Query(
            value="insert into payment (amount, time_stamp, payment_method, booking_id) values (:amount, timestamp(:timeStamp), :paymentMethod, :bookingId)",
            nativeQuery = true
    )
    @Transactional
    public void insertPayment(@Param("amount") Integer amount, @Param("timeStamp") String timeStamp, @Param("paymentMethod") Integer paymentMethod, @Param("bookingId") Integer bookingId);
}