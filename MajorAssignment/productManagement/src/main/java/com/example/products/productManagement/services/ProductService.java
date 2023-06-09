package com.example.products.productManagement.services;

import com.example.products.productManagement.models.Product;
import com.example.products.productManagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {

        System.out.println(productRepository.findAll());
        return productRepository.findAll();
    }

    public List<Product> getByCategory(String rating, String price, String category) {
        return productRepository.getByCategory(rating, price, category);
    }


    public List<Product> sortBYFieldPrice(String itemField) {
        return productRepository.sortBYFieldPrice(itemField);
    }

    public List<Product> sortBYFieldRating(String itemField) {

        return productRepository.sortBYFieldRating(itemField);
    }

    public Optional<Product> getByProductId(Long id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Product product) {
        return  productRepository.save(product);
    }
}