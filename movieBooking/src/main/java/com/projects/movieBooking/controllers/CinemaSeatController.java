package com.projects.movieBooking.controllers;

import com.projects.movieBooking.dto.CinemaSeatDTO;
import com.projects.movieBooking.services.CinemaSeatService;
import com.projects.movieBooking.viewobjects.CinemaSeatQueryVO;
import com.projects.movieBooking.viewobjects.CinemaSeatUpdateVO;
import com.projects.movieBooking.viewobjects.CinemaSeatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/cinemaSeat")
public class CinemaSeatController {

    @Autowired
    private CinemaSeatService cinemaSeatService;

    @PostMapping
    public String save(@Valid @RequestBody CinemaSeatVO vO) {
        return cinemaSeatService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        cinemaSeatService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody CinemaSeatUpdateVO vO) {
        cinemaSeatService.update(id, vO);
    }

    @GetMapping("/{id}")
    public CinemaSeatDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return cinemaSeatService.getById(id);
    }

    @GetMapping
    public Page<CinemaSeatDTO> query(@Valid CinemaSeatQueryVO vO) {
        return cinemaSeatService.query(vO);
    }
}
