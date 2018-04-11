package com.xgn.canalclient;

import com.xgn.canalclient.service.CanalService;
import com.xgn.canalclient.service.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Optional;
import java.util.function.Consumer;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.xgn.canalclient")
@Slf4j
public class CanalClientApplication {

    @Autowired
    private KafkaService kafkaService;

    @Autowired
    private CanalService canalService;

    public static void main(String[] args) {
        SpringApplication.run(CanalClientApplication.class, args);
    }


    @Scheduled(fixedRate = 1000 * 60)
    public void tick() {
        kafkaService.sendMessage("fuck", "aaaaaaaaaaaaaaaaaaa");
        log.debug("kafka tick");
    }


    @KafkaListener(topics = {"fuck"})
    public void receive(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record);
        if (kafkaMessage.isPresent()) {
            log.debug("kafka message {}", kafkaMessage);
        }
    }

}