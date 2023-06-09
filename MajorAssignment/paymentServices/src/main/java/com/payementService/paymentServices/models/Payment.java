package com.payementService.paymentServices.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "payment")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {
    @Id
    Long id ;
    Long userId ;
    Long  orderId ;
    String paymentMethod ;
    Long amount ;
    String paymentStatus ;
    String paymentDate ;
}
