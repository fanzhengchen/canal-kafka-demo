package com.xgn.canalclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService {

    @Autowired
    private KafkaTemplate kafkaTemplate;


    @Override
    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

}
