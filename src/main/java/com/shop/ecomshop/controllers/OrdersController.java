package com.shop.ecomshop.controllers;
import com.shop.ecomshop.exception.ResourceNotFoundException;
import com.shop.ecomshop.models.Orders;
import com.shop.ecomshop.repositories.OrdersRepository;
import com.shop.ecomshop.repositories.ProductsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/orders")
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Orders> getOrdersById(@PathVariable(value = "id") Long orderId) throws ResourceNotFoundException {
        Orders orders = ordersRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found for this ::" + " " + orderId));
        return ResponseEntity.ok().body(orders);
    }

    @PostMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public Orders createOrder(@Valid @RequestBody Orders orders) {
        return ordersRepository.save(orders);
    }

    @PutMapping ResponseEntity<Orders> updateOrders(@PathVariable(value = "id") Long orderId
            , @Valid @RequestBody Orders orderDetails) throws ResourceNotFoundException {
        Orders orders =
                ordersRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found for this is :: " + " " + orderId));
        //data for creating an order
        //noOfProducts, totalPrice, orderStatus, date, productsOrdered
        orders.setNoOfProducts(orderDetails.getNoOfProducts());
        orders.setTotalPrice(orderDetails.getTotalPrice());
        orders.setOrderStatus(orderDetails.getOrderStatus());
        orders.setDate(orderDetails.getDate());
        orders.setProductsOrdered(orderDetails.getProductsOrdered());

        final Orders updatedOrders = ordersRepository.save(orders);
        return ResponseEntity.ok(updatedOrders);
    }

    @DeleteMapping("/orders/{id}")
    public Map<String, Boolean> deleteOrder(@PathVariable(value = "id") Long orderId) throws ResourceNotFoundException {
        Orders orders = ordersRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found for this id::" + orderId));
        ordersRepository.delete(orders);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}


