package iuh.fit.se.orderservice.services.impl;

import iuh.fit.se.orderservice.dtos.Product;
import iuh.fit.se.orderservice.entities.Order;
import iuh.fit.se.orderservice.repositories.OrderRepository;
import iuh.fit.se.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public Order save(Order order) {
        // Gọi ProductService để giảm stock
        String productServiceUrl = "http://localhost:8082/products/" + order.getProductId();
        Product product = restTemplate.getForObject(productServiceUrl, Product.class);

        if (product == null || product.getStock() < order.getQuantity()) {
            throw new RuntimeException("Product not available or insufficient stock");
        }

        // Cập nhật stock
        product.setStock(product.getStock() - order.getQuantity());
        restTemplate.put(productServiceUrl, product);

        // Lưu order
        return orderRepository.save(order);
    }

    @Override
    public Order findById(long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}