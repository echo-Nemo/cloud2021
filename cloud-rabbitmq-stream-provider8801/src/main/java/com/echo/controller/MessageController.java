package com.echo.controller;


import com.echo.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MessageController {

    @Autowired
    private IMessageService messageServices;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageServices.sendMessage();
    }

}
