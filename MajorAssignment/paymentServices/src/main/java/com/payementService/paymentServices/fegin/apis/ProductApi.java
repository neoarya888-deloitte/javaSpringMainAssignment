package com.payementService.paymentServices.fegin.apis;


import com.payementService.paymentServices.enity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name="productManagements",url = "http://localhost:8081/api/product")

public interface ProductApi {
    @RequestMapping(method = RequestMethod.GET,value = "/getbyproductid/{productid}")
    Optional<Product> getProductId(@PathVariable Long productid);

    @PutMapping("/productid")
    public Product updateProduct(@RequestBody Product product);

}

