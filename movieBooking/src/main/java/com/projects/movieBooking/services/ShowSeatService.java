package com.projects.movieBooking.services;

import com.projects.movieBooking.dto.ShowSeatDTO;
import com.projects.movieBooking.entities.ShowSeat;
import com.projects.movieBooking.repositories.ShowSeatRepository;
import com.projects.movieBooking.viewobjects.ShowSeatQueryVO;
import com.projects.movieBooking.viewobjects.ShowSeatUpdateVO;
import com.projects.movieBooking.viewobjects.ShowSeatVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ShowSeatService {

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public Integer save(ShowSeatVO vO) {
        ShowSeat bean = new ShowSeat();
        BeanUtils.copyProperties(vO, bean);
        bean = showSeatRepository.save(bean);
        return bean.getShowSeatId();
    }

    public void delete(Integer id) {
        showSeatRepository.deleteById(id);
    }

    public void update(Integer id, ShowSeatUpdateVO vO) {
        ShowSeat bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        showSeatRepository.save(bean);
    }

    public ShowSeatDTO getById(Integer id) {
        ShowSeat original = requireOne(id);
        return toDTO(original);
    }

    public Page<ShowSeatDTO> query(ShowSeatQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ShowSeatDTO toDTO(ShowSeat original) {
        ShowSeatDTO bean = new ShowSeatDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private ShowSeat requireOne(Integer id) {
        return showSeatRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
