package com.stupin.core.repository;

import com.stupin.core.domain.model.Mechanic;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MechanicRepository extends ReactiveMongoRepository<Mechanic, String> {
}
