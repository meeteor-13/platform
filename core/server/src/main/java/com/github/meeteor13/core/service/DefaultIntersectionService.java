package com.github.meeteor13.core.service;

import com.github.meeteor13.core.domain.Intersection;
import com.github.meeteor13.core.domain.Location;
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

    private final ReactiveMongoOperations mongoTemplate;

    @Override
    public Flux<Intersection> calculate(Date startDate, Date endDate) {
        final MatchOperation dateMatcher = new MatchOperation(Criteria.where("date").gte(startDate).lte(endDate));
        return mongoTemplate.aggregate(
            Aggregation.newAggregation(
                dateMatcher
                //TODO add operators
            ),
            Location.class,
            Intersection.class
        );
    }
}
