package com.pitaza170.accountservice.service;

import org.springframework.kafka.annotation.KafkaListener;


public interface ConsumerUserService {

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
    void consumer(String message);

}
