package com.projects.movieBooking.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class CityDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer cityId;

    private String name;

}
