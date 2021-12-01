package com.projects.movieBooking.controllers;

import com.projects.movieBooking.dto.PaymentDTO;
import com.projects.movieBooking.services.PaymentService;
import com.projects.movieBooking.viewobjects.PaymentQueryVO;
import com.projects.movieBooking.viewobjects.PaymentUpdateVO;
import com.projects.movieBooking.viewobjects.PaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public String save(@Valid @RequestBody PaymentVO vO) {
        return paymentService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        paymentService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody PaymentUpdateVO vO) {
        paymentService.update(id, vO);
    }

    @GetMapping("/{id}")
    public PaymentDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return paymentService.getById(id);
    }

    @GetMapping
    public Page<PaymentDTO> query(@Valid PaymentQueryVO vO) {
        return paymentService.query(vO);
    }
}
