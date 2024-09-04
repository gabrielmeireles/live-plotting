package com.liveplotting.proxy.controller;

import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {
    @SubscribeMapping("/topic")
    public void subscribe(String message) {
        System.out.println(message);
    }
}
