package com.projects.movieBooking.services;

import com.projects.movieBooking.dto.MovieDTO;
import com.projects.movieBooking.entities.Movie;
import com.projects.movieBooking.repositories.MovieRepository;
import com.projects.movieBooking.viewobjects.MovieQueryVO;
import com.projects.movieBooking.viewobjects.MovieUpdateVO;
import com.projects.movieBooking.viewobjects.MovieVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    /*public Integer save(MovieVO vO) {
        Movie bean = new Movie();
        BeanUtils.copyProperties(vO, bean);
        bean = movieRepository.save(bean);
        return bean.getMovieId();
    }*/

    public void delete(Integer id) {
        movieRepository.deleteById(id);
    }

    public void update(Integer id, MovieUpdateVO vO) {
        Movie bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        movieRepository.save(bean);
    }

    public MovieDTO getById(Integer id) {
        Movie original = requireOne(id);
        return toDTO(original);
    }

    public Page<MovieDTO> query(MovieQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MovieDTO toDTO(Movie original) {
        MovieDTO bean = new MovieDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Movie requireOne(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
