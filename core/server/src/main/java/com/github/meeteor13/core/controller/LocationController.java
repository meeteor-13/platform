package com.github.meeteor13.core.controller;

import com.github.meeteor13.core.domain.Location;
import com.github.meeteor13.core.service.LocationService;
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

    private final LocationService service;

    @PreAuthorize("hasRole('LOCATION_READ')")
    @GetMapping(
        produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_STREAM_JSON_VALUE
        }
    )
    public Flux<Location> findAll() {
        return service.findAll();
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
        return service.findAllByUserId(userId);
    }

    @PreAuthorize("hasRole('LOCATION_CREATE')")
    @PostMapping
    public Mono<Location> save(@RequestBody Location location) {
        return service.save(location);
    }
}
