package com.echo.helloworld.service;

import com.echo.helloworld.servicefailback.GateWayServiceFallback;
import com.echo.helloworld.vo.City;
import com.echo.helloworld.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "weather-eureka-client-zuul", fallback = GateWayServiceFallback.class)
public interface GateWayService{

    @RequestMapping("/city/cities")
    List<City> getCities();

    @RequestMapping("/data/weather/city_id/{cityId}")
    WeatherResponse getWeatherInfoByCitiId(@PathVariable("cityId") String cityId);

}
