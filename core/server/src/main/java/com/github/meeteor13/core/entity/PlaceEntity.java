package com.github.meeteor13.core.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class PlaceEntity {
    @Id
    private String id;
    private String title;
    private String address;
    private PointEntity point;
}
