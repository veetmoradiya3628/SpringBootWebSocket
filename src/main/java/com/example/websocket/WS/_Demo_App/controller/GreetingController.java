package com.example.websocket.WS._Demo_App.controller;

import com.example.websocket.WS._Demo_App.model.Greeting;
import com.example.websocket.WS._Demo_App.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception{
        return new Greeting("Hello, "+ HtmlUtils.htmlEscape(message.name()) + "!");
    }
}
