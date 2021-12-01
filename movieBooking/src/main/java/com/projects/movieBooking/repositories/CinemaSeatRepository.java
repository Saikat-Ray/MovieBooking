package com.projects.movieBooking.repositories;

import com.projects.movieBooking.entities.CinemaSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CinemaSeatRepository extends JpaRepository<CinemaSeat, Integer>, JpaSpecificationExecutor<CinemaSeat> {
    @Query(
            value = "select count(1) from cinema_seat where cinema_hall_id = :cinemaHallId",
            nativeQuery = true
    )
    public Integer findTotalSeats(@Param("cinemaHallId") Integer cinemaHallId);
}