package com.lrsrodrigues.checkout.services;

import com.lrsrodrigues.checkout.dto.CheckoutDTO;
import com.lrsrodrigues.checkout.entities.Checkout;
import com.lrsrodrigues.checkout.entities.KartItem;
import com.lrsrodrigues.checkout.producer.OrderProducer;
import com.lrsrodrigues.checkout.producer.PaymentProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class CheckoutService {

    @Autowired
    private OrderProducer orderProducer;

    @Autowired
    private PaymentProducer paymentProducer;

    public Checkout insert(CheckoutDTO data) throws ExecutionException, InterruptedException {
        UUID uuid = UUID.randomUUID();
        Checkout checkout = new Checkout(uuid);

        orderProducer.send(uuid, data.getUserId(), data.getKartItems());

        Double totalPrice = data.getKartItems().stream()
                .map(KartItem::getPrice)
                .reduce(0.0, Double::sum);

        paymentProducer.send(totalPrice, uuid, data.getPaymentType());

        return checkout;
    }
}
