package com.github.meeteor13.core.repository;

import com.github.meeteor13.core.entity.IntersectionEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface IntersectionRepository extends ReactiveMongoRepository<IntersectionEntity, String> {
    Flux<IntersectionEntity> findAllByUsersContains(Long userId);
}
