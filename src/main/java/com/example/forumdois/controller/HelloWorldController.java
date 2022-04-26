package com.example.forumdois.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    private String execute(){
        return "Primeira página!!!";
    }

}
