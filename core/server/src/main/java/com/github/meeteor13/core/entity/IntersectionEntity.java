package com.github.meeteor13.core.entity;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Value
@Builder
public class IntersectionEntity {
    @Id
    private final String id;
    private final Set<Long> users;
    private final Point point;
    private final PlaceEntity place;
}
