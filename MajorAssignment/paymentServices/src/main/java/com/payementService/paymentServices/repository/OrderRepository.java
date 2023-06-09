package com.payementService.paymentServices.repository;

import com.payementService.paymentServices.models.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Long> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO orders ( userid, orderdate, totalamount, shippingaddress, paymentstatus, deliverystatus) VALUES ( :userid, :orderdate, :totalamount,:shippingaddress, :paymentstatus, :deliverystatus);")
    void SaveSelected(Long userid, String orderdate, String totalamount, String shippingaddress, String paymentstatus, String deliverystatus);
}
