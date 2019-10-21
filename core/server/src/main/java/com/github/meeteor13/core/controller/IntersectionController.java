package com.github.meeteor13.core.controller;

import com.github.meeteor13.core.domain.Intersection;
import com.github.meeteor13.core.repository.IntersectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/intersections")
@RequiredArgsConstructor
public class IntersectionController {

    private final IntersectionRepository intersectionRepository;

    @PreAuthorize("hasRole('INTERSECTION_READ')")
    @GetMapping(
        produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_STREAM_JSON_VALUE
        }
    )
    public Flux<Intersection> findAll() {
//        return intersectionRepository.findAll();
        return Flux.empty();
    }

    @PreAuthorize("hasRole('INTERSECTION_READ')")
    @GetMapping(
        params = {
            "userId"
        },
        produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_STREAM_JSON_VALUE
        }
    )
    public Flux<Intersection> findAllByUserId(@RequestParam Long userId) {
//        return intersectionRepository.findAllByUsersContains(userId);
        return Flux.empty();
    }
}
