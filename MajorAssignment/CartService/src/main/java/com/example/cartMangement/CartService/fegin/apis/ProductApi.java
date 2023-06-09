package com.example.cartMangement.CartService.fegin.apis;

import com.example.cartMangement.CartService.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name="productManagement",url = "http://localhost:8081/api/product")

public interface ProductApi {
    @RequestMapping(method = RequestMethod.GET,value = "/getbyproductid/{productid}")
    Optional<Product> getProductId(@PathVariable Long productid);

    @PutMapping("/productid")
    public Product updateProduct(@RequestBody Product product);

}

