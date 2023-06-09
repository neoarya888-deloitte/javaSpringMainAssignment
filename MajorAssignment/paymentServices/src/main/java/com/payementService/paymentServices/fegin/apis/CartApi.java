package com.payementService.paymentServices.fegin.apis;

import com.payementService.paymentServices.enity.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@FeignClient(name="productManagement",url = "http://localhost:8084/api/cart")
public interface CartApi {
    @GetMapping("/cartdetails/{cartid}")
    public Cart getCartDetailsByID(@PathVariable Long cartid);

    @DeleteMapping("/{cartid}")
    public HttpStatus deleteItemFromCart(@PathVariable Long cartid);
}
