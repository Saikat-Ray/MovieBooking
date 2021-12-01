package com.projects.movieBooking.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "cinema_hall")
public class CinemaHall implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cinema_hall_id", nullable = false)
    private Integer cinemaHallId;

    @Column(name = "name")
    private String name;

    @Column(name = "no_of_seats")
    private Integer noOfSeats;

    @Column(name = "cinema_id")
    private Integer cinemaId;

}
