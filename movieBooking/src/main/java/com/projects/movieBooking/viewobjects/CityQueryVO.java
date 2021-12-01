package com.projects.movieBooking.viewobjects;


import lombok.Data;

import java.io.Serializable;

@Data
public class CityQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer cityId;

    private String name;

}
