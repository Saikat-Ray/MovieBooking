package com.projects.movieBooking.viewobjects;


import lombok.Data;

import java.io.Serializable;

@Data
public class ShowSeatQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer showSeatId;

    private Integer status;

    private Integer price;

    private Integer cinemaSeatId;

    private Integer showId;

    private Integer bookingId;

}
