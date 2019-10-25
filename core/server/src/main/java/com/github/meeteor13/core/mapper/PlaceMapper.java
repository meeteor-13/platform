package com.github.meeteor13.core.mapper;

import com.github.meeteor13.core.domain.Place;
import com.github.meeteor13.core.entity.PlaceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PointMapper.class})
public interface PlaceMapper {
    PlaceMapper INSTANCE = Mappers.getMapper(PlaceMapper.class);

    Place map(PlaceEntity entity);

    PlaceEntity map(Place dto);
}
