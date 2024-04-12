package com.example.eurder.controllers;

import com.example.eurder.abstraction.mappers.eurder.EurderMapper;
import com.example.eurder.services.EurderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/" + EurderController.RESOURCE_NAME)
public class EurderController {

    public static final String RESOURCE_NAME = "orders";

    private final EurderService orderService;
    private final EurderMapper orderMapper;

    public EurderController(EurderService orderService, EurderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }
}
