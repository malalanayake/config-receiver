package com.sysensor.config.controller;

import com.sysensor.config.config.APIConfig;
import com.sysensor.config.table.ApplicationConfig;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(APIConfig.API)
public class ApplicationConfigAPI {

    Logger LOG = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/application-config", method = RequestMethod.POST)
    @ResponseBody
    public ApplicationConfig addRoute(@RequestBody ApplicationConfig applicationConfig) {

        return applicationConfig;
    }

    @RequestMapping("/hello")
    public String  getHello() {

        return "Hello";
    }
}
