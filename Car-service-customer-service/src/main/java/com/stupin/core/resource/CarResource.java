package com.stupin.core.resource;

import com.stupin.config.ApiVersion;
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

import static com.stupin.core.resource.CarResource.BASE_URL;

@RestController
@RequestMapping(BASE_URL)
public class CarResource {
	private static final Logger LOG = LoggerFactory.getLogger(CarResource.class);

	public static final String BASE_URL = ApiVersion.VERSION_1_0 + "/car";

	final CarService carService;

	public CarResource(final CarService carService) {
		this.carService = carService;
	}

	@GetMapping("/all")
	public Flux<Car> findAllCars() {
		LOG.debug("Received GET request to get all cars");
		return carService.getAllCars();
	}

	@GetMapping("/{id}")
	public Mono<Car> findAllCars(@PathVariable final Long id) {
		LOG.debug("Received GET request to get car with id{}", id);
		return carService.getById(id);
	}
}
