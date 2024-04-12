package com.example.eurder.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/" + ItemController.RESOURCE_NAME)
public class ItemController {

    public static final String RESOURCE_NAME = "items";


}
