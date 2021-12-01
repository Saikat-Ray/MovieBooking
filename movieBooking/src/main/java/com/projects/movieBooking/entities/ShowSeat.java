package com.projects.movieBooking.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "show_seat")
public class ShowSeat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "show_seat_id", nullable = false)
    private Integer showSeatId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "price")
    private Integer price;

    @Column(name = "cinema_seat_id")
    private Integer cinemaSeatId;

    @Column(name = "show_id")
    private Integer showId;

    @Column(name = "booking_id")
    private Integer bookingId;

    public Integer getShowSeatId() {
        return showSeatId;
    }

    public void setShowSeatId(Integer showSeatId) {
        this.showSeatId = showSeatId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCinemaSeatId() {
        return cinemaSeatId;
    }

    public void setCinemaSeatId(Integer cinemaSeatId) {
        this.cinemaSeatId = cinemaSeatId;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }
}
