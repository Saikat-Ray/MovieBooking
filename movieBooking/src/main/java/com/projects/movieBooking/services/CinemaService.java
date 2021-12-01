package com.projects.movieBooking.services;

import com.projects.movieBooking.dto.CinemaDTO;
import com.projects.movieBooking.entities.Cinema;
import com.projects.movieBooking.repositories.CinemaRepository;
import com.projects.movieBooking.viewobjects.CinemaQueryVO;
import com.projects.movieBooking.viewobjects.CinemaUpdateVO;
import com.projects.movieBooking.viewobjects.CinemaVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public Integer save(CinemaVO vO) {
        Cinema bean = new Cinema();
        BeanUtils.copyProperties(vO, bean);
        bean = cinemaRepository.save(bean);
        return bean.getCinemaId();
    }

    public void delete(Integer id) {
        cinemaRepository.deleteById(id);
    }

    public void update(Integer id, CinemaUpdateVO vO) {
        Cinema bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cinemaRepository.save(bean);
    }

    public CinemaDTO getById(Integer id) {
        Cinema original = requireOne(id);
        return toDTO(original);
    }

    public Page<CinemaDTO> query(CinemaQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CinemaDTO toDTO(Cinema original) {
        CinemaDTO bean = new CinemaDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Cinema requireOne(Integer id) {
        return cinemaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
