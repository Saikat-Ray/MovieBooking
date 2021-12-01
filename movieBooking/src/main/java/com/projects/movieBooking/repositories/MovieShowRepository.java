package com.projects.movieBooking.repositories;

import com.projects.movieBooking.entities.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieShowRepository extends JpaRepository<MovieShow, Integer>, JpaSpecificationExecutor<MovieShow> {
    @Query(
            value="select ms.* from movie_show ms where ms.cinema_hall_id = :cinemaHallId and ms.movie_id = :movie",
            nativeQuery = true
    )
    public List<MovieShow> findShowByMovieAndCinemaQuery(@Param("movie") Integer movie, @Param("cinemaHallId") Integer cinemaHallId);
}