package ru.netology.bff.controller;

import ru.netology.bff.model.UserDto;
import ru.netology.bff.model.OrderDto;
import ru.netology.bff.model.UserProfileDto;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/api/site-bff")
public class BffController {

    private final RestClient restClient;

    public BffController(RestClient.Builder builder) {
        this.restClient = builder.build();
    }

    @GetMapping("/user/{userId}")
    public UserProfileDto getUserProfile(
            @PathVariable Long userId
    ) {

        UserDto user = restClient.get()
                .uri(
                        "http://localhost:8081/api/users/{userId}",
                        userId
                )
                .retrieve()
                .body(UserDto.class);

        List<OrderDto> orders = restClient.get()
                .uri(
                        "http://localhost:8082/api/orders/by-user/{userId}",
                        userId
                )
                .retrieve()
                .body(
                        new ParameterizedTypeReference<List<OrderDto>>() {}
                );

        return new UserProfileDto(user, orders);
    }
}
