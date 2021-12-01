package com.projects.movieBooking.viewobjects;


import lombok.Data;

import java.io.Serializable;

@Data
public class CinemaQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer cinemaId;

    private String name;

    private Integer noOfHalls;

    private Integer cityId;

}
