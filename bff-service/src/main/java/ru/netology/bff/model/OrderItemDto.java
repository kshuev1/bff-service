package ru.netology.bff.model;

import java.math.BigDecimal;

public record OrderItemDto(
        String name,
        int quantity,
        BigDecimal price
)
{}
