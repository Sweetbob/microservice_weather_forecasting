package com.echo.helloworld.service;

import com.echo.helloworld.vo.City;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherService {
    //logger
    private Logger logger = LoggerFactory.getLogger(WeatherService.class);
    //expire time of pointed key
    private static final long TIME_OUT = 1800L;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final String BASEICURI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    GateWayService citiesFeignService;

    public void collectWeatherInfoByCityId(String cityId) {
        writeWeatherInfoByCityId(cityId);
    }


    /**
     * synchronize the data of list of cities.
     */
    public void syncWeatherOfListOfCities() {

        List<City> cities = citiesFeignService.getCities();
        for (City city : cities) {
            writeWeatherInfoByCityId(city.getWeatherCode());
        }
    }

    private void writeWeatherInfoByCityId(String cityId) {
        String uri = BASEICURI + "citykey=" + cityId;
        // point url as key of redis, and json response as value of it
        String jsonData = null;
        ObjectMapper om = new ObjectMapper();
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        jsonData = response.getBody();
        stringRedisTemplate.opsForValue().set(uri, jsonData, TIME_OUT, TimeUnit.SECONDS);
        logger.info("city id : " + cityId + "has synchronized");
    }
}
