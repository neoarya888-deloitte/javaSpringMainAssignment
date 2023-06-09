package com.payementService.paymentServices.services;

import com.payementService.paymentServices.controller.PaymentController;
import com.payementService.paymentServices.enity.Cart;
import com.payementService.paymentServices.enity.Product;
import com.payementService.paymentServices.exceptions.ResourceNotFoundException;
import com.payementService.paymentServices.fegin.apis.CartApi;
import com.payementService.paymentServices.fegin.apis.ProductApi;
import com.payementService.paymentServices.fegin.apis.UserApi;
import com.payementService.paymentServices.models.Order;
import com.payementService.paymentServices.repository.OrderRepository;
import com.payementService.paymentServices.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CheckoutService {
    private static Logger logger = LoggerFactory.getLogger(CheckoutService.class);
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    PaymentController paymentController;
    @Autowired
    ProductApi productApi;
    @Autowired
    UserApi userApi;
    @Autowired
    CartApi cartApi;

    public Order checkOutCartItem(Long cartid) {
        String Status = paymentController.payment();
        System.out.println(Status);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime current = LocalDateTime.now();
        if(Status.equals("Paid")){
            System.out.println(cartApi.getCartDetailsByID(cartid));
           Cart cart = cartApi.getCartDetailsByID(cartid);
           cartApi.deleteItemFromCart(cartid);
           System.out.println("jo");
          Optional< Product> pro = productApi.getProductId(cart.getProductid());
          int availabilty = Integer.parseInt(pro.get().getAvailability());
          pro.get().setAvailability(String.valueOf(availabilty-1));
           productApi.updateProduct(pro.get());
           Order c = new Order();
            c.setUserid(cart.getUserid());
            c.setDeliverystatus("Not delivered");
            c.setOrderdate(current.format(formatter));
            c.setTotalamount(cart.getPrice());
            c.setShippingaddress("Gaha Nagar, Mumbai 500069");
            c.setPaymentstatus(Status);
            System.out.println(c);
           orderRepository.SaveSelected( c.getUserid(), c.getOrderdate(),c.getTotalamount(), c.getShippingaddress(),c.getPaymentstatus(), c.getDeliverystatus());
            System.out.println(c);
           return c;
        }
        else{

            logger.error("Payment failure ", this.getClass().getName());
            throw new ResourceNotFoundException();
        }

    }
}
