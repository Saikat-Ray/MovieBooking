package com.projects.movieBooking.controllers;

import com.projects.movieBooking.dto.CinemaHallDTO;
import com.projects.movieBooking.services.CinemaHallService;
import com.projects.movieBooking.viewobjects.CinemaHallQueryVO;
import com.projects.movieBooking.viewobjects.CinemaHallUpdateVO;
import com.projects.movieBooking.viewobjects.CinemaHallVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/cinemaHall")
public class CinemaHallController {

    @Autowired
    private CinemaHallService cinemaHallService;

    @PostMapping
    public String save(@Valid @RequestBody CinemaHallVO vO) {
        return cinemaHallService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        cinemaHallService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody CinemaHallUpdateVO vO) {
        cinemaHallService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CinemaHallDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return cinemaHallService.getById(id);
    }

    @GetMapping
    public Page<CinemaHallDTO> query(@Valid CinemaHallQueryVO vO) {
        return cinemaHallService.query(vO);
    }
}
