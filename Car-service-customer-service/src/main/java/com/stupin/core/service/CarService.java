package com.stupin.core.service;

import com.stupin.core.domain.model.Car;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CarService {

	Flux<Car> getAllCars();

	Flux<Car> getCarsByUserId(String userId);

	Mono<Car> getById(Long id);
}
