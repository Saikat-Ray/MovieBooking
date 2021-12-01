package com.projects.movieBooking.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "movie_id", nullable = false)
    private Integer movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "duration")
    private Integer duration;

}
