package com.echo.helloworld.service;

import com.echo.helloworld.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("weather-eureka-client-zuul")
public interface GateWayService {

    @RequestMapping("/city/cities")
    List<City> getCities();

}
