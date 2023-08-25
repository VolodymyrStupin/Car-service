package com.stupin.core.service;

import com.stupin.core.domain.model.Manager;
import com.stupin.core.domain.model.Mechanic;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ManagerService {

	Mono<Manager> geById(String id);

	Flux<Manager> getAll();
	
	Mono<Manager> save(Manager manager);
}
