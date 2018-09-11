package com.echo.helloworld.controller;

import com.echo.helloworld.service.CitiesService;
import com.echo.helloworld.vo.City;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CitiesController {

    @Autowired
    private CitiesService citiesService;

    @RequestMapping("/cities")
    @HystrixCommand(defaultFallback = "defaultGetWeatherInfoByCityIdFallback")
    public List<City> getWeatherInfoByCityId(){
        return citiesService.getCities();
    }

    public List<City> defaultGetWeatherInfoByCityIdFallback(){
        return new ArrayList<City>();
    }

}
