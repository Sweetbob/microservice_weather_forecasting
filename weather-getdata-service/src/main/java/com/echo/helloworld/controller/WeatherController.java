package com.echo.helloworld.controller;

import com.echo.helloworld.service.WeatherService;
import com.echo.helloworld.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/city_id/{cityId}")
    public WeatherResponse getWeatherInfoByCityId(@PathVariable String cityId){
        return weatherService.getWeatherResponseByCityId(cityId);
    }

}
