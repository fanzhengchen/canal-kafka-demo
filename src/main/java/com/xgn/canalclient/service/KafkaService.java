package com.xgn.canalclient.service;

public interface KafkaService {

    public void sendMessage(String topic, String message);
}
