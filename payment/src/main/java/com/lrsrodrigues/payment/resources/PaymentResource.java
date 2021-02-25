package com.lrsrodrigues.payment.resources;

import com.lrsrodrigues.payment.entities.Payment;
import com.lrsrodrigues.payment.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/payment")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Payment>> findAll() {
        List<Payment> paymentList = paymentService.findAll();
        return ResponseEntity.ok().body(paymentList);
    }

    @GetMapping(value = "/{payment.id}")
    public ResponseEntity<Payment> findById(@PathVariable("payment.id") Integer id) {
        Payment payment = paymentService.findById(id);
        return ResponseEntity.ok().body(payment);
    }

    @GetMapping(value = "/get-payment-uuid/{payment.uuid}")
    public ResponseEntity<Payment> findByUuid(@PathVariable("payment.uuid") UUID uuid) {
        Payment payment = paymentService.findByUuid(uuid);
        return ResponseEntity.ok().body(payment);
    }
}
