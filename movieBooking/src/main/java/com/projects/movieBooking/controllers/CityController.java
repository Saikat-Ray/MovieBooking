package com.projects.movieBooking.controllers;

import com.projects.movieBooking.dto.CityDTO;
import com.projects.movieBooking.services.CityService;
import com.projects.movieBooking.viewobjects.CityQueryVO;
import com.projects.movieBooking.viewobjects.CityUpdateVO;
import com.projects.movieBooking.viewobjects.CityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public String save(@Valid @RequestBody CityVO vO) {
        return cityService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        cityService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody CityUpdateVO vO) {
        cityService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CityDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return cityService.getById(id);
    }

    @GetMapping
    public Page<CityDTO> query(@Valid CityQueryVO vO) {
        return cityService.query(vO);
    }
}
