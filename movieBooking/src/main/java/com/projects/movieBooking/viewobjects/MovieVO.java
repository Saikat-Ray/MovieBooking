package com.projects.movieBooking.viewobjects;

import com.sun.istack.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class MovieVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer movieId;

    private String title;

    private Date releaseDate;

    private Integer duration;

}
