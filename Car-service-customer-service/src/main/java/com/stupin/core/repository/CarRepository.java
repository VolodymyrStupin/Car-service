package com.stupin.core.repository;

import com.stupin.core.domain.model.Car;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CarRepository extends R2dbcRepository<Car, Long> {

	@Query("SELECT * FROM cars WHERE user_id = :userId")
	Flux<Car> findCarsByUserId(String userId);
}
