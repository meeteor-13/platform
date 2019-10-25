package com.github.meeteor13.core.domain;

import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class Location {
    private final String id;
    private final Long userId;
    private final Date date;
    private final Point point;
}
