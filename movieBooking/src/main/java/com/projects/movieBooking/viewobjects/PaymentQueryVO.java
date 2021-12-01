package com.projects.movieBooking.viewobjects;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class PaymentQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer paymentId;

    private Integer amount;

    private Date timeStamp;

    private Integer transactionId;

    private Integer paymentMethod;

    private Integer bookingId;

    private LocalDate timestamp;

}
