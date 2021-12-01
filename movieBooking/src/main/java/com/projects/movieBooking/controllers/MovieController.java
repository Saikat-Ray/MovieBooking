package com.projects.movieBooking.controllers;

import com.projects.movieBooking.dto.MovieDTO;
import com.projects.movieBooking.services.MovieService;
import com.projects.movieBooking.viewobjects.MovieQueryVO;
import com.projects.movieBooking.viewobjects.MovieUpdateVO;
import com.projects.movieBooking.viewobjects.MovieVO;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /*@PostMapping
    public String save( @RequestBody MovieVO vO) {
        return movieService.save(vO).toString();
    }*/

    @DeleteMapping("/{id}")
    public void delete( @NotNull @PathVariable("id") Integer id) {
        movieService.delete(id);
    }

    @PutMapping("/{id}")
    public void update( @NotNull @PathVariable("id") Integer id,
                        @RequestBody MovieUpdateVO vO) {
        movieService.update(id, vO);
    }

    @GetMapping("/{id}")
    public MovieDTO getById( @NotNull @PathVariable("id") Integer id) {
        return movieService.getById(id);
    }

    @GetMapping
    public Page<MovieDTO> query( MovieQueryVO vO) {
        return movieService.query(vO);
    }
}
