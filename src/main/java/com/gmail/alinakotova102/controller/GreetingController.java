package com.gmail.alinakotova102.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//програмный модуль
@Controller
public class GreetingController {

    //слушает запросы от пользователя и возвращает какие-то данные
    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("some", "hello, let's go!!");
        return "main";
    }
}
