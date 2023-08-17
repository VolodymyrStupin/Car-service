package com.stupin.core.service;

import com.stupin.core.domain.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

	Flux<User> gelAllUsers();

	Mono<User> getUserById(String id);
}
