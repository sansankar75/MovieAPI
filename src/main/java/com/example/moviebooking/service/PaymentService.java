package com.example.moviebooking.service;

import com.example.moviebooking.entity.Payment;
import com.example.moviebooking.exception.ResourceNotFoundException;
import com.example.moviebooking.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    public Payment getById(Integer id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + id));
    }

    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }
}
