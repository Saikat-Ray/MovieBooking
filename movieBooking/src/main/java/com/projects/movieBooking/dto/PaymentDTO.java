package com.projects.movieBooking.dto;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class PaymentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer paymentId;

    private Integer amount;

    private Date timeStamp;

    private Integer transactionId;

    private Integer paymentMethod;

    private Integer bookingId;

    private LocalDate timestamp;

}
