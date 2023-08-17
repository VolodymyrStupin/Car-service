package com.stupin.core.service.impl;

import com.stupin.core.domain.model.User;
import com.stupin.core.repository.UserRepository;
import com.stupin.core.service.CarService;
import com.stupin.core.service.UserService;
import com.stupin.core.service.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	private final UserRepository userRepository;

	private final CarService carService;

	public UserServiceImpl(
		final UserRepository userRepository,
		final CarService carService
	) {
		this.userRepository = userRepository;
		this.carService = carService;
	}

	@Override
	public Flux<User> gelAllUsers() {
		LOG.debug("In gelAllUsers - find all users");
		return userRepository.findAll()
			.flatMap(user -> carService.getCarsByUserId(user.getId())
				.collectList()
				.map(cars -> new User(user.getId(), user.getFirstName(), user.getLastName(), cars)))
			.switchIfEmpty(Flux.error(new UserNotFoundException("No one user was found")));
	}

	@Override
	public Mono<User> getUserById(final String id) {
		LOG.debug("In getById - find user with id{}", id);
		return userRepository.findById(id)
			.flatMap(user -> carService.getCarsByUserId(user.getId())
				.collectList()
				.map(cars -> new User(user.getId(), user.getFirstName(), user.getLastName(), cars)))
			.switchIfEmpty(Mono.error(new UserNotFoundException("User with id " + id + " not found")));
	}
}
