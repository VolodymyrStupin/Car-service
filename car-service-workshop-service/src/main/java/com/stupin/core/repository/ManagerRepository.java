package com.stupin.core.repository;

import com.stupin.core.domain.model.Manager;
import com.stupin.core.domain.model.Mechanic;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ManagerRepository  extends ReactiveMongoRepository<Manager, String>{
}
