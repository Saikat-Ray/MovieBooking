package com.projects.movieBooking.controllers;

import com.projects.movieBooking.dto.ShowSeatDTO;
import com.projects.movieBooking.services.ShowSeatService;
import com.projects.movieBooking.viewobjects.ShowSeatQueryVO;
import com.projects.movieBooking.viewobjects.ShowSeatUpdateVO;
import com.projects.movieBooking.viewobjects.ShowSeatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/showSeat")
public class ShowSeatController {

    @Autowired
    private ShowSeatService showSeatService;

    @PostMapping
    public String save(@Valid @RequestBody ShowSeatVO vO) {
        return showSeatService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        showSeatService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody ShowSeatUpdateVO vO) {
        showSeatService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ShowSeatDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return showSeatService.getById(id);
    }

    @GetMapping
    public Page<ShowSeatDTO> query(@Valid ShowSeatQueryVO vO) {
        return showSeatService.query(vO);
    }
}
