package com.liveplotting.proxy.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import com.liveplotting.proxy.model.MessageDTO;

@Controller
@EnableScheduling
public abstract class MessageSender {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    protected abstract MessageDTO GenerateMessage();

    @Scheduled(fixedRate = 50)
    public void send() {
        MessageDTO message = GenerateMessage();
        messagingTemplate.convertAndSend("/topic", message);
    }
}
