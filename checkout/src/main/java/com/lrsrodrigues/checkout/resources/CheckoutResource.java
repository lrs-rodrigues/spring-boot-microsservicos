package com.lrsrodrigues.checkout.resources;

import com.lrsrodrigues.checkout.dto.CheckoutDTO;
import com.lrsrodrigues.checkout.entities.Checkout;
import com.lrsrodrigues.checkout.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/v1/checkout")
public class CheckoutResource {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping
    public ResponseEntity<Checkout> insert(@RequestBody CheckoutDTO checkoutDTO) throws ExecutionException, InterruptedException {
        Checkout checkout = checkoutService.insert(checkoutDTO);
        return ResponseEntity.ok().body(checkout);
    }
}
