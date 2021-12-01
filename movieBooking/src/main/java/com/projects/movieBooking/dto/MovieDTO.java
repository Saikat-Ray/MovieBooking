package com.projects.movieBooking.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MovieDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer movieId;

    private String title;

    private Date releaseDate;

    private Integer duration;

}
