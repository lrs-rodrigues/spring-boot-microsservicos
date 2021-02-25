package com.lrsrodrigues.payment.repositories;

import com.lrsrodrigues.payment.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    Payment findByUuid(UUID uuid);

}
