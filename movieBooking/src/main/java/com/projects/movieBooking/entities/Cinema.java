package com.projects.movieBooking.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "cinema")
public class Cinema implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cinema_id", nullable = false)
    private Integer cinemaId;

    @Column(name = "name")
    private String name;

    @Column(name = "no_of_halls")
    private Integer noOfHalls;

    @Column(name = "city_id")
    private Integer cityId;

}
