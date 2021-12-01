package com.projects.movieBooking.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "cinema_seat")
public class CinemaSeat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cinema_seat_id", nullable = false)
    private Integer cinemaSeatId;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "type")
    private Integer type;

    @Column(name = "cinema_hall_id")
    private Integer cinemaHallId;

}
