package com.stupin.core.service;

import com.stupin.core.domain.model.Mechanic;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MechanicService {

	Mono<Mechanic> geById(String id);

	Flux<Mechanic> getAll();
	
	Mono<Mechanic> save(Mechanic mechanic);
}
