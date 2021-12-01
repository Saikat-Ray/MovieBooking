package com.projects.movieBooking.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class CinemaSeatDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer cinemaSeatId;

    private Integer seatNumber;

    private Integer type;

    private Integer cinemaHallId;

}
