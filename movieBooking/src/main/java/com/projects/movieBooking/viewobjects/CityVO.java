package com.projects.movieBooking.viewobjects;

import com.sun.istack.NotNull;
import lombok.Data;

import java.io.Serializable;


@Data
public class CityVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer cityId;

    private String name;

}
