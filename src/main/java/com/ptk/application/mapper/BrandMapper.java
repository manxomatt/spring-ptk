package com.ptk.application.mapper;

import com.ptk.application.dto.brand.BrandRequest;
import com.ptk.application.dto.brand.BrandResponse;
import com.ptk.domain.model.brand.Brand;
import org.mapstruct.*;

/**
 * MapStruct mapper for Brand entity.
 */
@Mapper(componentModel = "spring")
public interface BrandMapper {

    /**
     * Convert Brand entity to BrandResponse DTO.
     */
    BrandResponse toResponse(Brand brand);

    /**
     * Convert BrandRequest DTO to Brand entity.
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    Brand toEntity(BrandRequest request);

    /**
     * Update existing Brand entity from BrandRequest DTO.
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    void updateEntity(@MappingTarget Brand brand, BrandRequest request);
}
