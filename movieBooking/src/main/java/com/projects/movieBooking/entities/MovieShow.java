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
@Table(name = "movie_show")
public class MovieShow implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "show_id", nullable = false)
    private Integer showId;

    @Column(name = "show_date")
    private Date showDate;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "cinema_hall_id")
    private Integer cinemaHallId;

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Integer cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }
}
