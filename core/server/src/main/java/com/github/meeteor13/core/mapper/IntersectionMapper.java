package com.github.meeteor13.core.mapper;

import com.github.meeteor13.core.domain.Intersection;
import com.github.meeteor13.core.entity.IntersectionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IntersectionMapper {
    IntersectionMapper INSTANCE = Mappers.getMapper(IntersectionMapper.class);

    Intersection map(IntersectionEntity entity);
}
