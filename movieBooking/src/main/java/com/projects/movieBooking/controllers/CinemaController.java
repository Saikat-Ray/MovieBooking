package com.projects.movieBooking.controllers;

import com.projects.movieBooking.dto.CinemaDTO;
import com.projects.movieBooking.services.CinemaService;
import com.projects.movieBooking.viewobjects.CinemaQueryVO;
import com.projects.movieBooking.viewobjects.CinemaUpdateVO;
import com.projects.movieBooking.viewobjects.CinemaVO;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @PostMapping
    public String save( @RequestBody CinemaVO vO) {
        return cinemaService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete( @NotNull @PathVariable("id") Integer id) {
        cinemaService.delete(id);
    }

    @PutMapping("/{id}")
    public void update( @NotNull @PathVariable("id") Integer id,
                        @RequestBody CinemaUpdateVO vO) {
        cinemaService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CinemaDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return cinemaService.getById(id);
    }

    @GetMapping
    public Page<CinemaDTO> query(@Valid CinemaQueryVO vO) {
        return cinemaService.query(vO);
    }
}
