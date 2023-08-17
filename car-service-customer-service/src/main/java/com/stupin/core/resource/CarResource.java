package com.stupin.core.resource;

import com.stupin.core.domain.model.Car;
import com.stupin.core.service.CarService;
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
public class CarResource {
	private static final Logger LOG = LoggerFactory.getLogger(CarResource.class);

	final CarService carService;

	public CarResource(final CarService carService) {
		this.carService = carService;
	}

	@GetMapping("/cars")
	public Flux<Car> findAllCars() {
		LOG.debug("Received GET request to get all cars");
		return carService.getAllCars();
	}

	@GetMapping("/car/{id}")
	public Mono<Car> findAllCars(@PathVariable final Long id) {
		LOG.debug("Received GET request to get car with id{}", id);
		return carService.getById(id);
	}
}
