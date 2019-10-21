package com.github.meeteor13.core.repository;

import com.github.meeteor13.core.entity.LocationEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface LocationRepository extends ReactiveMongoRepository<LocationEntity, String> {
    Flux<LocationEntity> findAllByUserId(Long userId);
}
