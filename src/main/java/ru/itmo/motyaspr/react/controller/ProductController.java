package ru.itmo.motyaspr.react.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import ru.itmo.motyaspr.react.model.Product;
import ru.itmo.motyaspr.react.model.UserProduct;
import ru.itmo.motyaspr.react.repository.ProductRepository;
import ru.itmo.motyaspr.react.repository.UserRepository;

import static ru.itmo.motyaspr.react.converter.FromRublesConverter.fromRubles;

@RestController
@RequestMapping("products")
class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Flux<UserProduct> getProducts(String userId) {
        return userRepository.findById(userId).flatMapMany(user ->
            productRepository
                .findAll()
                .map(product ->
                    new UserProduct(
                        product.getName(),  
                        userId,
                        fromRubles(product.getPriceInRubles(), user.getCurrency()))
                )
        );
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productRepository.save(product);
    }
}