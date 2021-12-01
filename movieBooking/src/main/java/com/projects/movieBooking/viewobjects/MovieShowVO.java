package com.projects.movieBooking.viewobjects;

import com.sun.istack.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class MovieShowVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer showId;

    private Date showDate;

    private Date startTime;

    private Date endTime;

    private Integer movieId;

    private Integer cinemaHallId;

}
