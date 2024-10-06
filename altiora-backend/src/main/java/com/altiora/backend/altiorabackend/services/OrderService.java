package com.altiora.backend.altiorabackend.services;

import com.altiora.backend.altiorabackend.application.dtos.request.OrderRequest;
import com.altiora.backend.altiorabackend.application.dtos.response.GetOrderResponse;
import com.altiora.backend.altiorabackend.infraestructure.repositories.jpa.ArticleRepositoryJPA;
import com.altiora.backend.altiorabackend.infraestructure.repositories.jpa.ClientRepositoryJPA;
import com.altiora.backend.altiorabackend.models.ArticleModel;
import com.altiora.backend.altiorabackend.models.ClientModel;
import com.altiora.backend.altiorabackend.models.OrderModel;
import com.altiora.backend.altiorabackend.infraestructure.repositories.jpa.OrderRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepositoryJPA orderRepository;
    @Autowired
    private ClientRepositoryJPA clientRepository;
    @Autowired
    private ArticleRepositoryJPA articleRepository;

    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderModel createOrder(OrderRequest orderRequest) {
        ClientModel client = clientRepository.findById(orderRequest.getClientId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        List<ArticleModel> articles = articleRepository.findAllById(orderRequest.getArticleIds());

        OrderModel order = new OrderModel();
        order.setClient(client);
        order.setArticles(articles);
        order.setDate(orderRequest.getDate());

        // Asignar la fecha actual si no se proporciona
        if (order.getDate() == null) {
            order.setDate(LocalDate.now());
        }

        OrderModel newOrderModel = orderRepository.save(order);

        String generatedCode = "OC-" + String.format("%06d", newOrderModel.getId());
        newOrderModel.setCode(generatedCode);

        return orderRepository.save(newOrderModel);
    }

    public OrderModel updateOrder(Long orderId, OrderRequest orderRequest) {
        // Buscar la orden existente por ID
        OrderModel existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        // Actualizar cliente
        ClientModel client = clientRepository.findById(orderRequest.getClientId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        existingOrder.setClient(client);

        // Actualizar artículos
        List<ArticleModel> articles = articleRepository.findAllById(orderRequest.getArticleIds());
        existingOrder.setArticles(articles);

        // Actualizar fecha si se proporciona
        if (orderRequest.getDate() != null) {
            existingOrder.setDate(orderRequest.getDate());
        }

        // Asignar la fecha actual si no se proporciona y si no hay fecha existente
        if (existingOrder.getDate() == null) {
            existingOrder.setDate(LocalDate.now());
        }

        // Guardar la orden actualizada en la base de datos
        OrderModel updatedOrderModel = orderRepository.save(existingOrder);

        return updatedOrderModel;
    }

    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

}
