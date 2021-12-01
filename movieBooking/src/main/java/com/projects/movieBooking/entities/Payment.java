package com.projects.movieBooking.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "payment")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "payment_id", nullable = false)
    private Integer paymentId;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "time_stamp")
    private Date timeStamp;

    @Column(name = "transaction_id")
    private Integer transactionId;

    @Column(name = "payment_method")
    private Integer paymentMethod;

    @Column(name = "booking_id")
    private Integer bookingId;

    @Column(name = "timestamp")
    private LocalDate timestamp;

}
