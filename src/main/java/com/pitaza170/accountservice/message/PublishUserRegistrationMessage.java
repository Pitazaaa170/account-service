package com.pitaza170.accountservice.message;

import com.pitaza170.accountservice.config.KafkaProperties;
import com.pitaza170.accountservice.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class PublishUserRegistrationMessage {

    private final KafkaTemplate<String, AuthMessage> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    public void sendMessage(AuthMessage authMessage) {
        log.info("AuthMessage send : {}", authMessage);
        kafkaTemplate.send(
            kafkaProperties.getTopic(),
            authMessage
        );

    }

}
