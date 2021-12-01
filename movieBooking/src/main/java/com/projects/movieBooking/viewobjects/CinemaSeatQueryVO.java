package com.projects.movieBooking.viewobjects;


import lombok.Data;

import java.io.Serializable;

@Data
public class CinemaSeatQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer cinemaSeatId;

    private Integer seatNumber;

    private Integer type;

    private Integer cinemaHallId;

}
