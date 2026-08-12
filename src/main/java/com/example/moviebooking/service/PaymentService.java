package com.example.moviebooking.service;

import com.example.moviebooking.dao.Payment;
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

    /**
     * Retrieves all payments.
     *
     * @return list of all payments
     */
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    /**
     * Retrieves a payment by its ID.
     *
     * @param id unique identifier of the payment
     * @return the payment matching the given ID
     * @throws ResourceNotFoundException if the payment does not exist
     */
    public Payment getById(Integer id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + id));
    }

    /**
     * Creates a new payment.
     *
     * @param payment payment data to be persisted
     * @return the newly created payment
     */
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }
}

