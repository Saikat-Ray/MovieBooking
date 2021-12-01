package com.projects.movieBooking.viewobjects;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String name;

    private String password;

}
