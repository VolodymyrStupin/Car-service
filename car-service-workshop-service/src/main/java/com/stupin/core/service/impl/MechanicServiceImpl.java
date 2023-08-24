package com.stupin.core.service.impl;

import com.stupin.core.domain.model.Mechanic;
import com.stupin.core.repository.MechanicRepository;
import com.stupin.core.service.MechanicService;
import com.stupin.core.service.exception.MechanicNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MechanicServiceImpl implements MechanicService {

	private static final Logger LOG = LoggerFactory.getLogger(MechanicServiceImpl.class);

	private final MechanicRepository mechanicRepository;

	public MechanicServiceImpl(final MechanicRepository mechanicRepository) {
		this.mechanicRepository = mechanicRepository;
	}

	@Override
	public Mono<Mechanic> geById(final String id) {
		LOG.debug("In geById - get mechanic with id{} from repository", id);
		return mechanicRepository
			.findById(id)
			.switchIfEmpty(Mono.error(new MechanicNotFoundException("Mechanic not found with id" + id)));
	}

	@Override
	public Flux<Mechanic> getAll() {
		LOG.debug("In geById - get all mechanics with from repository");
		return mechanicRepository
			.findAll()
			.switchIfEmpty(Flux.error(new MechanicNotFoundException("No one mechanic was found")));
	}

	@Override
	public Mono<Mechanic> save(final Mechanic mechanic) {
		return mechanicRepository.save(mechanic);
	}
}
