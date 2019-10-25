package com.github.meeteor13.core.entity;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PointEntity {
    private final double x;
    private final double y;
}
