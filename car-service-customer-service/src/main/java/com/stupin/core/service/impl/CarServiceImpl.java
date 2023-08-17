package com.stupin.core.service.impl;

import com.stupin.core.domain.model.Car;
import com.stupin.core.repository.CarRepository;
import com.stupin.core.service.CarService;
import com.stupin.core.service.exception.CarNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CarServiceImpl implements CarService {
	private static final Logger LOG = LoggerFactory.getLogger(CarServiceImpl.class);

	private final CarRepository carRepository;

	public CarServiceImpl(final CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public Flux<Car> getAllCars() {
		LOG.debug("In getAllCars - find all cars in repository");
		return carRepository.findAll();
	}

	@Override
	public Flux<Car> getCarsByUserId(final String userId) {
		return carRepository.findCarsByUserId(userId);
	}

	@Override
	public Mono<Car> getById(final Long id) {
		LOG.debug("In getById - find car with id{}", id);
		return carRepository.findById(id)
			.switchIfEmpty(Mono.error(new CarNotFoundException("Car with id " + id + " not found")));
	}
}
