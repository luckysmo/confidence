package ru.practicum.confidence.dto;

import lombok.Builder;
import lombok.Data;
import ru.practicum.confidence.model.Product;

@Data
@Builder
public class BasketDto {
    Long id;

    Product product;
}
