package com.stupin.core.resource;

import com.stupin.config.ApiVersion;
import com.stupin.core.domain.model.Manager;
import com.stupin.core.service.ManagerService;
import com.stupin.core.service.impl.ManagerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.stupin.core.resource.ManagerResource.BASE_URL;

@RestController
@RequestMapping(BASE_URL)
public class ManagerResource {
	private static final Logger LOG = LoggerFactory.getLogger(ManagerResource.class);
	public static final String BASE_URL = ApiVersion.VERSION_1_0 + "/managers";
	private final ManagerService managerService;

	public ManagerResource(final ManagerService managerService) {
		this.managerService = managerService;
	}

	@GetMapping("/{id}")
	public Mono<Manager> getManagerById(@PathVariable final String id) {
		LOG.debug("In getManagerById - Received GET request to get manager with id{}", id);

		return managerService.geById(id);
	}

	@GetMapping("/all")
	public Flux<Manager> getAllManagers() {
		LOG.debug("In getAllManagers - Received GET request to get all managers");

		return managerService.getAll();
	}

	@PostMapping ("/add")
	public Mono<Manager> addManager(@RequestBody final Manager manager) {
		LOG.debug("In getAllManagers - Received POST request to create new manager");

		return managerService.save(manager);
	}
}
