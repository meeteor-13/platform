package com.github.meeteor13.core.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Set;


@Data
@Builder
public class Intersection {
    private final String id;
    private final Set<Long> users;
    private final Point point;
    private final Place place;
}
