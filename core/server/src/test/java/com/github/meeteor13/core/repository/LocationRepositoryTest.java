package com.github.meeteor13.core.repository;

import com.github.meeteor13.core.AbstractIntegrationTest;
import com.github.meeteor13.core.entity.LocationEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;

import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    private LocationRepository repository;

    @Test
    public void saveTest() {
        final LocationEntity saved = repository
            .save(LocationEntity
                .builder()
                .userId(1L)
                .date(Date.from(Instant.now()))
                .point(new Point(2, 3))
                .build())
            .block();
        final LocationEntity found = repository.findById(saved.getId()).block();
        assertThat(found).usingRecursiveComparison().isEqualTo(saved);
    }
}
