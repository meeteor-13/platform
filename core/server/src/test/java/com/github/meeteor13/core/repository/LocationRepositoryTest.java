package com.github.meeteor13.core.repository;

import com.github.meeteor13.core.AbstractIntegrationTest;
import com.github.meeteor13.core.entity.LocationEntity;
import com.github.meeteor13.core.entity.PointEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class LocationRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    private LocationRepository repository;

    @Test
    void saveTest() {
        final LocationEntity saved = repository
            .save(LocationEntity
                .builder()
                .userId(1L)
                .date(Date.from(Instant.now()))
                .point(PointEntity.builder().x(1).y(2).build())
                .build())
            .block();
        final LocationEntity found = repository.findById(saved.getId()).block();
        assertThat(found).usingRecursiveComparison().isEqualTo(saved);
    }
}
