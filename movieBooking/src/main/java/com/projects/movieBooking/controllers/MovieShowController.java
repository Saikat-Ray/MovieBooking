package com.projects.movieBooking.controllers;

import com.projects.movieBooking.dto.MovieShowDTO;
import com.projects.movieBooking.services.MovieShowService;
import com.projects.movieBooking.viewobjects.MovieShowQueryVO;
import com.projects.movieBooking.viewobjects.MovieShowUpdateVO;
import com.projects.movieBooking.viewobjects.MovieShowVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/movieShow")
public class MovieShowController {

    @Autowired
    private MovieShowService movieShowService;

    @PostMapping
    public String save(@Valid @RequestBody MovieShowVO vO) {
        return movieShowService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        movieShowService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody MovieShowUpdateVO vO) {
        movieShowService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MovieShowDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return movieShowService.getById(id);
    }

    @GetMapping
    public Page<MovieShowDTO> query(@Valid MovieShowQueryVO vO) {
        return movieShowService.query(vO);
    }
}
