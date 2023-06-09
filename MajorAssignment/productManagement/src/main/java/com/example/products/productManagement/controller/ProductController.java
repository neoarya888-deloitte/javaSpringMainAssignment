package com.example.products.productManagement.controller;

import com.example.products.productManagement.models.Product;
import com.example.products.productManagement.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    private static Logger logger = LoggerFactory.getLogger(ProductController.class);
    @GetMapping("/allproducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{category}")
    public List<Product> getByCategory(@PathVariable String category , @RequestParam(value = "price",required = false) String Price,@RequestParam(value = "rating",required = false) String rating){
        return productService.getByCategory(rating,Price,category);
    }
    @GetMapping("/getbyproductid/{productid}")
    Optional<Product> getByProductId(@PathVariable Long productid){
        logger.info("retrieve all prodcuts");
        System.out.println("e");
        return  productService.getByProductId(productid);
    }
    @GetMapping("/sort/price/{sortByField}")
    public List<Product> sortByFieldPrice(@PathVariable String sortByField){
        return productService.sortBYFieldPrice(sortByField);
    }

    @GetMapping("/sort/rating/{sortByField}")
    public List<Product> sortByFieldRating(@PathVariable String sortByField){
        return productService.sortBYFieldRating(sortByField);
    }
    @PutMapping("/productid")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }


}
