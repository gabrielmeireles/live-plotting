package com.liveplotting.proxy.sender;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.liveplotting.proxy.model.MessageDTO;

@EnableScheduling
public abstract class MessageSender {
    protected abstract MessageDTO GenerateMessage();

    @Scheduled(fixedRate = 1000)
    public void send() {
        MessageDTO message = GenerateMessage();
        System.out.println(message.getValue());
    }
}
