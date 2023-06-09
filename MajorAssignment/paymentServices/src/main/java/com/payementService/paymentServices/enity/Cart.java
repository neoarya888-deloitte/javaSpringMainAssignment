package com.payementService.paymentServices.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
@Data
public class Cart {
    @Id
    private Long id;
    private Long productid;
    private Long userid;
    private String productTitle;
    private String category;
    private String price;
}