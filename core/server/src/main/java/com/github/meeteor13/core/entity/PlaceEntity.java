package com.github.meeteor13.core.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Value
@Builder
public class PlaceEntity {
    @Id
    private final String id;
    private final String title;
    private final String address;
    private final Point point;
}
