package iuh.fit.se.orderservice.services.impl;

import iuh.fit.se.orderservice.dtos.Product;
import iuh.fit.se.orderservice.entities.Order;
import iuh.fit.se.orderservice.repositories.OrderRepository;
import iuh.fit.se.orderservice.services.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
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
    @CircuitBreaker(name = "orderService", fallbackMethod = "fallbackSaveOrder")
    @Retry(name = "orderService")
    @RateLimiter(name = "orderService")
    public Order save(Order order) {
        String productServiceUrl = "http://localhost:8082/products/" + order.getProductId();
        Product product = restTemplate.getForObject(productServiceUrl, Product.class);

        if (product == null || product.getStock() < order.getQuantity()) {
            throw new RuntimeException("Product not available or insufficient stock");
        }

        product.setStock(product.getStock() - order.getQuantity());
        restTemplate.put(productServiceUrl, product);

        return orderRepository.save(order);
    }

    public Order fallbackSaveOrder(Order order, Throwable throwable) {
        throw new RuntimeException("Fallback: Unable to process order at this time");
    }

    @Override
    @CircuitBreaker(name = "orderService", fallbackMethod = "fallbackFindById")
    @Retry(name = "orderService")
    @RateLimiter(name = "orderService")
    public Order findById(long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order fallbackFindById(long id, Throwable throwable) {
        throw new RuntimeException("Fallback: Unable to fetch order with ID " + id + " at this time");
    }
}