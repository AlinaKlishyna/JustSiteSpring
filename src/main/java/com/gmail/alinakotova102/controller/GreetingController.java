package com.gmail.alinakotova102.controller;

import com.gmail.alinakotova102.domain.Message;
import com.gmail.alinakotova102.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//програмный модуль
@Controller
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;

    //слушает запросы от пользователя и возвращает какие-то данные
    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages",  messages);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        messageRepo.save(new Message(text, tag));
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages",  messages);
        return "main";
    }
}
