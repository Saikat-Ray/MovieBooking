package com.projects.movieBooking.services;

import com.projects.movieBooking.dto.CinemaSeatDTO;
import com.projects.movieBooking.entities.CinemaSeat;
import com.projects.movieBooking.repositories.CinemaSeatRepository;
import com.projects.movieBooking.viewobjects.CinemaSeatQueryVO;
import com.projects.movieBooking.viewobjects.CinemaSeatUpdateVO;
import com.projects.movieBooking.viewobjects.CinemaSeatVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CinemaSeatService {

    @Autowired
    private CinemaSeatRepository cinemaSeatRepository;

    public Integer save(CinemaSeatVO vO) {
        CinemaSeat bean = new CinemaSeat();
        BeanUtils.copyProperties(vO, bean);
        bean = cinemaSeatRepository.save(bean);
        return bean.getCinemaSeatId();
    }

    public void delete(Integer id) {
        cinemaSeatRepository.deleteById(id);
    }

    public void update(Integer id, CinemaSeatUpdateVO vO) {
        CinemaSeat bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cinemaSeatRepository.save(bean);
    }

    public CinemaSeatDTO getById(Integer id) {
        CinemaSeat original = requireOne(id);
        return toDTO(original);
    }

    public Page<CinemaSeatDTO> query(CinemaSeatQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CinemaSeatDTO toDTO(CinemaSeat original) {
        CinemaSeatDTO bean = new CinemaSeatDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private CinemaSeat requireOne(Integer id) {
        return cinemaSeatRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
