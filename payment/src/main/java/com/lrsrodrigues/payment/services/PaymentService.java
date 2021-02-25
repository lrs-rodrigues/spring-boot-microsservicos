package com.lrsrodrigues.payment.services;

import com.lrsrodrigues.payment.entities.Payment;
import com.lrsrodrigues.payment.repositories.PaymentRepository;
import com.lrsrodrigues.payment.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment findById(Integer id) {
        return paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Payment findByUuid(UUID uuid) {
        return paymentRepository.findByUuid(uuid);
    }

}
