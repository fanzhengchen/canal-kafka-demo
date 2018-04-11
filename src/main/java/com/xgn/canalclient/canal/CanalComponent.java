package com.xgn.canalclient.canal;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class CanalComponent {

    @Value("${canal.server}")
    private String serverAddress;

    @Value("${canal.port}")
    private int port;

    @Value("${canal.destination}")
    private String destination;

    @Bean
    public CanalConnector canalConnector(){
        return CanalConnectors.newSingleConnector(
               new InetSocketAddress(serverAddress,port),
                destination,"","");

    }

    @Bean
    public ExecutorService canalExecutorService(){
        return Executors.newFixedThreadPool(1);
    }

    @Bean
    public Thread canalThread(){
        return new Thread("canal client thread");
    }
}
