package com.example.moviebooking.controller;

import com.example.moviebooking.entity.Payment;
import com.example.moviebooking.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Retrieves all payments.
     *
     * @return list of all payments
     */
    @GetMapping
    public List<Payment> getAll() {
        return paymentService.getAll();
    }

    /**
     * Retrieves a payment by its ID.
     *
     * @param id unique identifier of the payment
     * @return the payment matching the given ID
     */
    @GetMapping("/{id}")
    public Payment getById(@PathVariable Integer id) {
        return paymentService.getById(id);
    }

    /**
     * Creates a new payment.
     *
     * @param paymentRequest payment data received in the request body
     * @return the newly created payment
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payment create(@Valid @RequestBody Payment paymentRequest) {
        return paymentService.create(paymentRequest);
    }
}

