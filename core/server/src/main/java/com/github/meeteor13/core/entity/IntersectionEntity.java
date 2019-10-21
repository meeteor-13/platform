package com.github.meeteor13.core.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document
@Data
@Builder
public class IntersectionEntity {
    @Id
    private String id;
    private Set<Long> users;
    private Point point;
    private PlaceEntity place;
}
