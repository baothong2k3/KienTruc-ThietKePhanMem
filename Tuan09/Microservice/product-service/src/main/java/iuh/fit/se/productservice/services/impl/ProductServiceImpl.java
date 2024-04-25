package iuh.fit.se.productservice.services.impl;

import iuh.fit.se.productservice.entities.Product;
import iuh.fit.se.productservice.repositories.ProductRepository;
import iuh.fit.se.productservice.services.ProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    @Modifying
    @Override
    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackSaveProduct")
    @Retry(name = "productService")
    @RateLimiter(name = "productService")
    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product fallbackSaveProduct(Product product, Throwable throwable) {
        throw new RuntimeException("Fallback: Unable to save product at this time");
    }

    @Transactional
    @Override
    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackFindAll")
    @Retry(name = "productService")
    @RateLimiter(name = "productService")
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> fallbackFindAll(Throwable throwable) {
        throw new RuntimeException("Fallback: Unable to fetch products at this time");
    }

    @Transactional
    @Override
    @CircuitBreaker(name = "productService", fallbackMethod = "fallbackFindById")
    @Retry(name = "productService")
    @RateLimiter(name = "productService")
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product fallbackFindById(Long id, Throwable throwable) {
        throw new RuntimeException("Fallback: Unable to fetch product with ID " + id + " at this time");
    }
}