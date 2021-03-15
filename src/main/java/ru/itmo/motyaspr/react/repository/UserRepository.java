package ru.itmo.motyaspr.react.repository;

import ru.itmo.motyaspr.react.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

}