package com.projects.movieBooking.services;

import com.projects.movieBooking.dto.CinemaHallDTO;
import com.projects.movieBooking.entities.CinemaHall;
import com.projects.movieBooking.repositories.CinemaHallRepository;
import com.projects.movieBooking.viewobjects.CinemaHallQueryVO;
import com.projects.movieBooking.viewobjects.CinemaHallUpdateVO;
import com.projects.movieBooking.viewobjects.CinemaHallVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CinemaHallService {

    @Autowired
    private CinemaHallRepository cinemaHallRepository;

    public Integer save(CinemaHallVO vO) {
        CinemaHall bean = new CinemaHall();
        BeanUtils.copyProperties(vO, bean);
        bean = cinemaHallRepository.save(bean);
        return bean.getCinemaHallId();
    }

    public void delete(Integer id) {
        cinemaHallRepository.deleteById(id);
    }

    public void update(Integer id, CinemaHallUpdateVO vO) {
        CinemaHall bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cinemaHallRepository.save(bean);
    }

    public CinemaHallDTO getById(Integer id) {
        CinemaHall original = requireOne(id);
        return toDTO(original);
    }

    public Page<CinemaHallDTO> query(CinemaHallQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CinemaHallDTO toDTO(CinemaHall original) {
        CinemaHallDTO bean = new CinemaHallDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CinemaHall requireOne(Integer id) {
        return cinemaHallRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
