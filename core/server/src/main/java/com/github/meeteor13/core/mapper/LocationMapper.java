package com.github.meeteor13.core.mapper;

import com.github.meeteor13.core.domain.Location;
import com.github.meeteor13.core.entity.LocationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PointMapper.class})
public interface LocationMapper {
    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    Location map(LocationEntity entity);

    LocationEntity map(Location location);
}
