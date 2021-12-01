package com.projects.movieBooking.repositories;

import com.projects.movieBooking.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Integer>, JpaSpecificationExecutor<Cinema> {
    @Query(
            value="select * from cinema c where c.city_id = ?1",
            nativeQuery = true
    )
    public List<Cinema> findQuery(Integer cityValue);
}