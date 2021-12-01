package com.projects.movieBooking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "booking")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "booking_id", nullable = false)
    private @Getter
    Integer bookingId;

    @Column(name = "no_of_seats")
    private @Setter @Getter Integer noOfSeats;

    @Column(name = "time_stamp")
    private @Setter @Getter Date timeStamp;

    @Column(name = "status")
    private @Setter @Getter Integer status;

    @Column(name = "user_id")
    private @Setter @Getter Integer userId;

    @Column(name = "show_id")
    private @Setter @Getter Integer showId;


    public Booking() {
    }

    public Booking( Integer noOfSeats, Date timeStamp, Integer status, Integer userId, Integer showId) {
        this.noOfSeats = noOfSeats;
        this.timeStamp = timeStamp;
        this.status = status;
        this.userId = userId;
        this.showId = showId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public Integer getNoOfSeats() {
        return noOfSeats;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getShowId() {
        return showId;
    }

}
