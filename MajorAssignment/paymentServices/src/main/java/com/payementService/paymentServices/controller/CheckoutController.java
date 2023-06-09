package com.payementService.paymentServices.controller;

import com.payementService.paymentServices.models.Order;
import com.payementService.paymentServices.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    @Autowired
    CheckoutService checkoutService;
    @PostMapping("/{cartid}")
    public Order checkOutCartItem(@PathVariable Long cartid){
        return  checkoutService.checkOutCartItem(cartid);

    }
}
