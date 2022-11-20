package com.pitaza170.accountservice.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("app.kafka.producer")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProducerProperties {

    private String topic;

}
