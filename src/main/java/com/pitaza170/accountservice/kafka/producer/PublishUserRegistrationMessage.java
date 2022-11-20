package com.pitaza170.accountservice.kafka.message;

import com.pitaza170.accountservice.config.ProducerProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class PublishUserRegistrationMessage {

    private final KafkaTemplate<String, AuthMessage> kafkaTemplate;
    private final ProducerProperties kafkaProperties;

    public void sendMessage(AuthMessage authMessage) {
        try {
            kafkaTemplate.send(
                    kafkaProperties.getTopic(),
                    authMessage
            );
            log.info("AuthMessage send : {}", authMessage);
        } catch (Exception e) {
            log.warn("Ошибка при отправке сообщения в топик , {}",e.getMessage());
        }


    }

}
