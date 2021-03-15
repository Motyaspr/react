package ru.itmo.motyaspr.react.repository;

import ru.itmo.motyaspr.react.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

}