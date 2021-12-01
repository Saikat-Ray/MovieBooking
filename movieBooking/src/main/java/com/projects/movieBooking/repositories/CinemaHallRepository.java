package com.projects.movieBooking.repositories;

import com.projects.movieBooking.entities.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CinemaHallRepository extends JpaRepository<CinemaHall, Integer>, JpaSpecificationExecutor<CinemaHall> {
    @Query(
            value="select * from cinema_hall ch where ch.cinema_id = :cinema",
            nativeQuery = true
    )
    public List<CinemaHall> findHallsQuery(@Param("cinema") Integer cinema);
}