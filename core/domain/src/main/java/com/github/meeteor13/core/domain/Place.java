package com.github.meeteor13.core.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Place {
    private final String id;
    private final String title;
    private final String address;
    private final Point point;
}
