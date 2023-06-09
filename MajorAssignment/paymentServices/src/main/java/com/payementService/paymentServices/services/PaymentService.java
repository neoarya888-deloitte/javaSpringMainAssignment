package com.payementService.paymentServices.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {
    Random random = new Random();
    boolean b = random.nextBoolean();

    public String pay() {
        System.out.println(b);
        if(b)
            return "Paid";
    return "Unpaid";
    }
}
