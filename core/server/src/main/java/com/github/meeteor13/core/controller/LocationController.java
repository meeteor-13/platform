package com.github.meeteor13.core.controller;

import com.github.meeteor13.core.domain.Location;
import com.github.meeteor13.core.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationRepository locationRepository;

    @PreAuthorize("hasRole('LOCATION_READ')")
    @GetMapping(
        produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_STREAM_JSON_VALUE
        }
    )
    public Flux<Location> findAll() {
//        return locationRepository.findAll();
        return Flux.empty();
    }

    @GetMapping(
        params = {
            "userId"
        },
        produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_STREAM_JSON_VALUE
        }
    )
    public Flux<Location> findAllByUserId(@RequestParam Long userId) {
//        return locationRepository.findAllByUserId(userId);
        return Flux.empty();
    }

    @PreAuthorize("hasRole('LOCATION_CREATE')")
    @PostMapping
    public Mono<Location> save(@RequestBody Location location) {
//        return locationRepository.save(location);
        return Mono.empty();
    }
}
