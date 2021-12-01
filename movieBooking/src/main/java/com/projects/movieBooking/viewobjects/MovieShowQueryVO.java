package com.projects.movieBooking.viewobjects;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MovieShowQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer showId;

    private Date showDate;

    private Date startTime;

    private Date endTime;

    private Integer movieId;

    private Integer cinemaHallId;

}
