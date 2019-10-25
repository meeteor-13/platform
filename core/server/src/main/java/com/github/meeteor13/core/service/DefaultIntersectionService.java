package com.github.meeteor13.core.service;

import com.github.meeteor13.core.domain.Intersection;
import com.github.meeteor13.core.entity.IntersectionEntity;
import com.github.meeteor13.core.entity.LocationEntity;
import com.github.meeteor13.core.mapper.IntersectionMapper;
import com.github.meeteor13.core.repository.IntersectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class DefaultIntersectionService implements IntersectionService {

    private final ReactiveMongoOperations ops;
    private final IntersectionRepository repository;

    @Override
    public Flux<Intersection> process(Date startDate, Date endDate) {
        final MatchOperation dateMatcher = new MatchOperation(Criteria.where("date").gte(startDate).lte(endDate));
        final Aggregation aggregation = Aggregation.newAggregation(
            dateMatcher
            //TODO add operators
        );
        final Flux<IntersectionEntity> intersections = ops.aggregate(aggregation, LocationEntity.class, IntersectionEntity.class);
        return repository.saveAll(intersections)
            .map(IntersectionMapper.INSTANCE::map);
    }

    @Override
    public Flux<Intersection> findAll() {
        return repository.findAll()
            .map(IntersectionMapper.INSTANCE::map);
    }

    @Override
    public Flux<Intersection> findAllByUserId(Long userId) {
        return repository.findAllByUsersContains(userId)
            .map(IntersectionMapper.INSTANCE::map);
    }
}
