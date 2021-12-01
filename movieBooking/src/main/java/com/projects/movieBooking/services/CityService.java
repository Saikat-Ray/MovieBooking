package com.projects.movieBooking.services;

import com.projects.movieBooking.dto.CityDTO;
import com.projects.movieBooking.entities.City;
import com.projects.movieBooking.repositories.CityRepository;
import com.projects.movieBooking.viewobjects.CityQueryVO;
import com.projects.movieBooking.viewobjects.CityUpdateVO;
import com.projects.movieBooking.viewobjects.CityVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public Integer save(CityVO vO) {
        City bean = new City();
        BeanUtils.copyProperties(vO, bean);
        bean = cityRepository.save(bean);
        return bean.getCityId();
    }

    public void delete(Integer id) {
        cityRepository.deleteById(id);
    }

    public void update(Integer id, CityUpdateVO vO) {
        City bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        cityRepository.save(bean);
    }

    public CityDTO getById(Integer id) {
        City original = requireOne(id);
        return toDTO(original);
    }

    public Page<CityDTO> query(CityQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CityDTO toDTO(City original) {
        CityDTO bean = new CityDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private City requireOne(Integer id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
