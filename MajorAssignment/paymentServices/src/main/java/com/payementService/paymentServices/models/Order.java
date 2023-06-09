package com.payementService.paymentServices.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Ignore;

import java.util.Date;

@Data
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    Long userid;
    String orderdate;
    String totalamount;
    String shippingaddress;
    String paymentstatus;
    String deliverystatus;
}
