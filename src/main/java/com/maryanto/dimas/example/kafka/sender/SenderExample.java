package com.maryanto.dimas.example.kafka.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
public class SenderExample {

    @Autowired
    private KafkaTemplate template;

    public void sendMessage(String message) {
        ListenableFuture<SendResult<String, String>> future = this.template.send("example", message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("Unable to send message: {}", message, throwable);
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                log.info("Send message: {}", message);
            }
        });
    }
}
