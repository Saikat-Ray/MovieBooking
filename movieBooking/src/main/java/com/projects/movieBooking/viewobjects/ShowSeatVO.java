package com.projects.movieBooking.viewobjects;

import com.sun.istack.NotNull;
import lombok.Data;

import java.io.Serializable;


@Data
public class ShowSeatVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer showSeatId;

    private Integer status;

    private Integer price;

    private Integer cinemaSeatId;

    private Integer showId;

    private Integer bookingId;

}
