package com.github.meeteor13.core.mapper;

import com.github.meeteor13.core.domain.Point;
import com.github.meeteor13.core.entity.PointEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PointMapper {
    PointMapper INSTANCE = Mappers.getMapper(PointMapper.class);

    Point map(PointEntity entity);

    PointEntity map(Point dto);
}
