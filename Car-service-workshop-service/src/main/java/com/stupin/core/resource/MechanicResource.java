package com.stupin.core.resource;

import com.stupin.config.ApiVersion;
import com.stupin.core.domain.model.Mechanic;
import com.stupin.core.service.MechanicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.stupin.core.resource.MechanicResource.BASE_URL;

@RestController
@RequestMapping(BASE_URL)
public class MechanicResource {
	private static final Logger LOG = LoggerFactory.getLogger(MechanicResource.class);

	public static final String BASE_URL = ApiVersion.VERSION_1_0 + "/mechanic";

	private final MechanicService mechanicService;

	public MechanicResource(final MechanicService mechanicService) {
		this.mechanicService = mechanicService;
	}

	@GetMapping("/all")
	public Flux<Mechanic> getAllMechanics() {
		LOG.debug("In getAllMechanics - Received GET request to get all mechanics");
		return mechanicService.getAll();
	}

	@PostMapping("/add")
	public Mono<Mechanic> addMechanic(@RequestBody final Mechanic mechanic) {
		LOG.debug("In addMechanic - Received POST request to create new mechanic");
		return mechanicService.save(mechanic);
	}
}