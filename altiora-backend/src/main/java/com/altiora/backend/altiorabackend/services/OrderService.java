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
}
