package com.liveplotting.proxy.sender.implementation;

import org.springframework.stereotype.Component;
import com.liveplotting.proxy.model.MessageDTO;
import com.liveplotting.proxy.sender.MessageSender;

@Component
public class SineWaveMessageSender extends MessageSender {
    private double amplitude;
    private double frequency;
    private long referenceTimestamp;

    public SineWaveMessageSender() {
        referenceTimestamp = System.currentTimeMillis();
    }

    public double generateSineWaveValue(long currentTimestamp) {
        double elapsedTime = (currentTimestamp - referenceTimestamp) / 1000.0;
        double angularFrequency = 2.0 * Math.PI * frequency;
        return amplitude * Math.sin(angularFrequency * elapsedTime);
    }

    @Override
    public MessageDTO GenerateMessage() {
        long timestamp = System.currentTimeMillis();
        MessageDTO message = new MessageDTO();
        message.setValue(generateSineWaveValue(timestamp));
        message.setTimestamp(timestamp);
        return message;
    }
}
