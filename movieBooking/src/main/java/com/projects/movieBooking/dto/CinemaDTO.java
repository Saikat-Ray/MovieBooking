package com.projects.movieBooking.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class CinemaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer cinemaId;

    private String name;

    private Integer noOfHalls;

    private Integer cityId;

}
