package com.projects.movieBooking.viewobjects;

import com.sun.istack.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@Data
public class BookingVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer bookingId;

    private Integer noOfSeats;

    private Date timeStamp;

    private Integer status;

    private Integer userId;

    private Integer showId;

    private LocalDate timestamp;

}
