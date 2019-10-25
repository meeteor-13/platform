package com.github.meeteor13.core.service;

    import com.github.meeteor13.core.domain.Location;
    import reactor.core.publisher.Flux;
    import reactor.core.publisher.Mono;

public interface LocationService {
    Flux<Location> findAll();

    Flux<Location> findAllByUserId(Long userId);

    Mono<Location> save(Location location);
}
