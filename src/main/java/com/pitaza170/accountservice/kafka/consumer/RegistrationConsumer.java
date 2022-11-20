package com.pitaza170.accountservice.kafka.consumer;

import com.pitaza170.accountservice.kafka.message.SuccessfulRegistrationMessage;
import com.pitaza170.accountservice.service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class RegistrationConsumer {

    private final UserRegistrationService userRegistrationService;

    @KafkaListener(topics = "${app.kafka.consumer.topic}")
    public void receive(SuccessfulRegistrationMessage successfulRegistrationMessage) {
        log.debug("Получены данные из топика registrations {}" , successfulRegistrationMessage);
        userRegistrationService.receiveRegistration(successfulRegistrationMessage.getUserId());
    }
}
