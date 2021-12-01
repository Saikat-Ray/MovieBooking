package com.projects.movieBooking.viewobjects;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class CinemaHallUpdateVO extends CinemaHallVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
