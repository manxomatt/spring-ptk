package com.ptk.application.mapper;

import com.ptk.application.dto.product.ProductRequest;
import com.ptk.application.dto.product.ProductResponse;
import com.ptk.domain.model.product.Product;
import org.mapstruct.*;

import java.util.List;

/**
 * MapStruct mapper for Product entity and DTOs.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    @Mapping(target = "active", expression = "java(product.isActive())")
    ProductResponse toResponse(Product product);

    List<ProductResponse> toResponseList(List<Product> products);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    Product toEntity(ProductRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(ProductRequest request, @MappingTarget Product product);
}
