package ru.practicum.confidence.service;

import ru.practicum.confidence.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto create(ProductDto productDto);

    ProductDto updateUser(ProductDto productDto);

    void deleteProduct(Long productId);

    ProductDto getById(Long productId);

    List<ProductDto> getProductsByCategory(ProductDto productDto);
}
