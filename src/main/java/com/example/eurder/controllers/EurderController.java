package com.example.eurder.controllers;

import com.example.eurder.abstraction.dto.eurder.EurderAfterCreationDto;
import com.example.eurder.abstraction.dto.eurder.EurderCreationDto;
import com.example.eurder.abstraction.mappers.eurder.EurderMapper;
import com.example.eurder.services.EurderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.eurder.controllers.EurderController.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/" + RESOURCE_NAME)
public class EurderController {

    public static final String RESOURCE_NAME = "orders";

    private final EurderService orderService;
    private final EurderMapper orderMapper;

    public EurderController(EurderService orderService, EurderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public EurderAfterCreationDto createOrder(@RequestBody EurderCreationDto creationDto) {
        return orderMapper.toEurderAfterCreationDto(
                orderService.createOrder(
                        orderMapper.toDomain(creationDto)));
    }
}
