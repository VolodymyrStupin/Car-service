package com.stupin.core.resource;

import com.stupin.core.domain.model.User;
import com.stupin.core.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class UserResource {
	private static final Logger LOG = LoggerFactory.getLogger(UserResource.class);

	final UserServiceImpl userServiceImpl;

	public UserResource(final UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@GetMapping("/users")
	public Flux<User> getAllUsers() {
		LOG.debug("Received GET request to get all users");
		return userServiceImpl.gelAllUsers();
	}

	@GetMapping("/user/{id}")
	public Mono<User> getAllUsers(@PathVariable String id) {
		LOG.debug("Received GET request to get user with id{}", id);
		return userServiceImpl.getUserById(id);
	}
}
