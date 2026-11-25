package ru.netology.bff.model;

import java.util.List;

public record UserProfileDto(
        UserDto user,
        List<OrderDto> orders
) {
}
