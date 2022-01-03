package com.example.ivd.controller;

import com.example.ivd.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class notificationControllers {

    @Autowired
    RegisterService regservice;
}
