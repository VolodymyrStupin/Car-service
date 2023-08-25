package com.stupin.core.service.impl;

import com.stupin.core.domain.model.Manager;
import com.stupin.core.repository.ManagerRepository;
import com.stupin.core.service.ManagerService;
import com.stupin.core.service.exception.ManagerNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ManagerServiceImpl implements ManagerService {

	private static final Logger LOG = LoggerFactory.getLogger(ManagerServiceImpl.class);

	private final ManagerRepository managerRepository;

	public ManagerServiceImpl(final ManagerRepository managerRepository) {
		this.managerRepository = managerRepository;
	}

	@Override
	public Mono<Manager> geById(final String id) {
		LOG.debug("In geById - try to find manager with id{} in repository", id);
		return managerRepository
			.findById(id)
			.switchIfEmpty(Mono.error(new ManagerNotFoundException("Manager with id " + id + " not found")));
	}

	@Override
	public Flux<Manager> getAll() {
		LOG.debug("In getAll - try to find all managers in repository");
		return managerRepository.findAll().switchIfEmpty(Flux.error(new ManagerNotFoundException("No one manager was found")));
	}

	@Override
	public Mono<Manager> save(final Manager manager) {
		LOG.debug("In save - try to save manager in repository");
		return managerRepository.save(manager);
	}
}
