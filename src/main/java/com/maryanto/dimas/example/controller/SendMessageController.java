package com.maryanto.dimas.example.controller;

import com.maryanto.dimas.example.kafka.sender.SenderExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/message")
public class SendMessageController {

    @Autowired
    public SenderExample sender;

    @GetMapping("/request/send")
    public ResponseEntity<?> sendMessage(@RequestParam String message) {
        sender.sendMessage(message);
        return ok().build();
    }
}
