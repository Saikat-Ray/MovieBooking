package com.projects.movieBooking.dto;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class BookingDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer bookingId;

    private Integer noOfSeats;

    private Date timeStamp;

    private Integer status;

    private Integer userId;

    private Integer showId;

    private LocalDate timestamp;

}
