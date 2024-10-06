package com.altiora.backend.altiorabackend.controllers;

import com.altiora.backend.altiorabackend.application.dtos.request.OrderRequest;
import com.altiora.backend.altiorabackend.application.dtos.response.GetOrderResponse;
import com.altiora.backend.altiorabackend.models.OrderModel;
import com.altiora.backend.altiorabackend.services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderModel> createOrder(@RequestBody OrderRequest order){
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrderModel>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(),HttpStatus.OK);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderModel> updateOrder(
            @PathVariable Long orderId,
            @RequestBody OrderRequest orderRequest) {
        OrderModel updatedOrder = orderService.updateOrder(orderId, orderRequest);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

}
