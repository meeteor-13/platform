package com.github.meeteor13.core.job;

import com.github.meeteor13.core.domain.Intersection;
import com.github.meeteor13.core.repository.IntersectionRepository;
import com.github.meeteor13.core.service.IntersectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class IntersectionJob {

    private final IntersectionRepository repository;
    private final IntersectionService service;

    @Scheduled(cron = "${application.jobs.intersection.cron}")
    public void run() {
        final LocalDateTime currentDate = LocalDateTime.now();
        final LocalDateTime startDate = currentDate.minusDays(3);
        final Flux<Intersection> intersections = service.calculate(
            new Date(startDate.toInstant(ZoneOffset.UTC).toEpochMilli()),
            new Date(currentDate.toInstant(ZoneOffset.UTC).toEpochMilli())
        );
//        repository.saveAll(intersections);//TODO wrap with service
    }
}
