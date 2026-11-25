package ru.netology.bff.model;

import java.math.BigDecimal;
import java.util.List;

public record OrderDto(
        Long id,
        Long userId,
        BigDecimal amount,
        String currency,
        List<OrderItemDto> items
) {
}