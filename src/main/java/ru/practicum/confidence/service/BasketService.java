package ru.practicum.confidence.service;

import ru.practicum.confidence.dto.BasketDto;

public interface BasketService {
    BasketDto updateBasket(BasketDto basketDto, Long productId, Long userId);

    void deleteProductsInBasket(Long basketId,Long productId);
}
