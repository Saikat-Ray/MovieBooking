package com.projects.movieBooking.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class CinemaHallDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer cinemaHallId;

    private String name;

    private Integer noOfSeats;

    private Integer cinemaId;

}
