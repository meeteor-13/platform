package com.github.meeteor13.core.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@Builder
public class LocationEntity {
    @Id
    private String id;
    private Long userId;
    private Date date;
    private Point point;
}
