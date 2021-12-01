package com.projects.movieBooking.controllers;

import com.projects.movieBooking.dto.UserDTO;
import com.projects.movieBooking.services.UserService;
import com.projects.movieBooking.viewobjects.UserQueryVO;
import com.projects.movieBooking.viewobjects.UserUpdateVO;
import com.projects.movieBooking.viewobjects.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String save(@Valid @RequestBody UserVO vO) {
        return userService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody UserUpdateVO vO) {
        userService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @GetMapping
    public Page<UserDTO> query(@Valid UserQueryVO vO) {
        return userService.query(vO);
    }
}
