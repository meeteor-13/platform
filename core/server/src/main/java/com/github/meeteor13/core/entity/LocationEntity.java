package com.github.meeteor13.core.entity;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Value
@Builder
public class LocationEntity {
    @Id
    private final String id;
    private final Long userId;
    private final Date date;
    private final PointEntity point;
}
