package com.projects.movieBooking.viewobjects;

import com.sun.istack.NotNull;
import lombok.Data;

import java.io.Serializable;


@Data
public class CinemaSeatVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer cinemaSeatId;

    private Integer seatNumber;

    private Integer type;

    private Integer cinemaHallId;

}
