package com.projects.movieBooking.viewobjects;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MovieQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer movieId;

    private String title;

    private Date releaseDate;

    private Integer duration;

}
