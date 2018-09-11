package com.echo.helloworld.service;

import com.echo.helloworld.vo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {
    //logger
    Logger logger = LoggerFactory.getLogger(WeatherService.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final String BASEICURI = "http://wthrcdn.etouch.cn/weather_mini?";

    public WeatherResponse getWeatherResponseByCityId(String cityId) {
        String uri = BASEICURI + "citykey=" + cityId;
        return getWeatherInformationFromRedis(uri);
    }

    private WeatherResponse getWeatherInformationFromRedis(String uri) {

        // point url as key of redis, and json response as value of it
        WeatherResponse weatherResponse = null;
        String jsonData = null;
        ObjectMapper om = new ObjectMapper();
        //get data from redis if exist, or get from internet api and store it to redis for some time
        if (stringRedisTemplate.hasKey(uri)) {
            logger.info("redis has cached data!");
            jsonData = stringRedisTemplate.opsForValue().get(uri);
        } else {
            logger.error("redis has no cached data.");
           throw new RuntimeException("No related data available.");
        }
        try {
            weatherResponse = om.readValue(jsonData, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weatherResponse;
    }

}
