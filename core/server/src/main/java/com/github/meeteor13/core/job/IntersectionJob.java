package com.github.meeteor13.core.job;

import com.github.meeteor13.core.service.IntersectionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor
public class IntersectionJob {

    private final IntersectionService service;

    @Scheduled(cron = "${application.jobs.intersection.cron}")
    public void run() {
        final LocalDateTime currentDate = LocalDateTime.now();
        final LocalDateTime startDate = currentDate.minusDays(3);
        service.process(
            new Date(startDate.toInstant(ZoneOffset.UTC).toEpochMilli()),
            new Date(currentDate.toInstant(ZoneOffset.UTC).toEpochMilli())
        )
        .doOnComplete(() -> log.debug("Intersections have been re-calculated"));
    }
}
