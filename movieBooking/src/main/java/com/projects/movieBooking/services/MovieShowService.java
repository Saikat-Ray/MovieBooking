package com.projects.movieBooking.services;

import com.projects.movieBooking.dto.MovieShowDTO;
import com.projects.movieBooking.entities.MovieShow;
import com.projects.movieBooking.repositories.MovieShowRepository;
import com.projects.movieBooking.viewobjects.MovieShowQueryVO;
import com.projects.movieBooking.viewobjects.MovieShowUpdateVO;
import com.projects.movieBooking.viewobjects.MovieShowVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MovieShowService {

    @Autowired
    private MovieShowRepository movieShowRepository;

    public Integer save(MovieShowVO vO) {
        MovieShow bean = new MovieShow();
        BeanUtils.copyProperties(vO, bean);
        bean = movieShowRepository.save(bean);
        return bean.getShowId();
    }

    public void delete(Integer id) {
        movieShowRepository.deleteById(id);
    }

    public void update(Integer id, MovieShowUpdateVO vO) {
        MovieShow bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        movieShowRepository.save(bean);
    }

    public MovieShowDTO getById(Integer id) {
        MovieShow original = requireOne(id);
        return toDTO(original);
    }

    public Page<MovieShowDTO> query(MovieShowQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MovieShowDTO toDTO(MovieShow original) {
        MovieShowDTO bean = new MovieShowDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private MovieShow requireOne(Integer id) {
        return movieShowRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
