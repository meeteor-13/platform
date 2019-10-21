package com.github.meeteor13.core.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Point {
    private final double x;
    private final double y;
}
