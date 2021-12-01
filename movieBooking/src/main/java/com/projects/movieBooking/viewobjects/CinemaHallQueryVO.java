package com.projects.movieBooking.viewobjects;


import lombok.Data;

import java.io.Serializable;

@Data
public class CinemaHallQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer cinemaHallId;

    private String name;

    private Integer noOfSeats;

    private Integer cinemaId;

}
