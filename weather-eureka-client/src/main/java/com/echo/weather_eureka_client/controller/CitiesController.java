package com.echo.weather_eureka_client.controller;

import com.echo.weather_eureka_client.service.GateWayService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitiesController {

    @Autowired
    private GateWayService gateWayService;

    @HystrixCommand(fallbackMethod = "getCitiesFailBack")
    public String getCities(){
        return gateWayService.getCities().toString();
    }

    public String getCitiesFailBack(){
        return "apologize，no service available!";
    }

}
