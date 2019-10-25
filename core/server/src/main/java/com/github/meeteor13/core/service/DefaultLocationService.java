package com.github.meeteor13.core.service;

import com.github.meeteor13.core.domain.Location;
import com.github.meeteor13.core.mapper.LocationMapper;
import com.github.meeteor13.core.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DefaultLocationService implements LocationService {

    private final LocationRepository repository;

    @Override
    public Flux<Location> findAll() {
        return repository.findAll()
            .map(LocationMapper.INSTANCE::map);
    }

    @Override
    public Flux<Location> findAllByUserId(Long userId) {
        return repository.findAllByUserId(userId)
            .map(LocationMapper.INSTANCE::map);
    }

    @Override
    public Mono<Location> save(Location location) {
        return repository.save(LocationMapper.INSTANCE.map(location))
            .map(LocationMapper.INSTANCE::map);
    }
}
