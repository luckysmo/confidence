package ru.practicum.confidence.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.practicum.confidence.dto.ProductDto;
import ru.practicum.confidence.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapperDto {

    Product toDto(ProductDto productDto);

    ProductDto toProductDto(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductDto(ProductDto dto, @MappingTarget Product product);
}
