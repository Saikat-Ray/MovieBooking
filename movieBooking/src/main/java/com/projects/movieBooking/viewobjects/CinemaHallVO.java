package com.projects.movieBooking.viewobjects;

import com.sun.istack.NotNull;
import lombok.Data;

import java.io.Serializable;


@Data
public class CinemaHallVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer cinemaHallId;

    private String name;

    private Integer noOfSeats;

    private Integer cinemaId;

}
