package com.xgn.canalclient.runner;

import com.xgn.canalclient.service.CanalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CanalRunner implements ApplicationRunner {

    @Autowired
    CanalService canalService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        canalService.start();
    }
}
