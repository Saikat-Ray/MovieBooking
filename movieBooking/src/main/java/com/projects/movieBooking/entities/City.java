package com.projects.movieBooking.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "city")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "city_id", nullable = false)
    private Integer cityId;

    @Column(name = "name")
    private String name;

}
