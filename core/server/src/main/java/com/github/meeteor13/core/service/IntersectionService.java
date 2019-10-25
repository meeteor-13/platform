package com.github.meeteor13.core.service;

import com.github.meeteor13.core.domain.Intersection;
import reactor.core.publisher.Flux;

import java.util.Date;

public interface IntersectionService {
    Flux<Intersection> process(Date startDate, Date endDate);

    Flux<Intersection> findAll();

    Flux<Intersection> findAllByUserId(Long userId);
}
