package ru.netology.bff.model;

public record UserDto(
        Long id,
        String fullName,
        String deliveryAddress,
        String phone,
        String email
) {
}