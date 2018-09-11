package com.echo.helloworld.servicefailback;

import com.echo.helloworld.service.GateWayService;
import com.echo.helloworld.vo.City;
import com.echo.helloworld.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GateWayServiceFallback implements GateWayService {
    @Override
    public List<City> getCities() {
        return null;
    }

    @Override
    public WeatherResponse getWeatherInfoByCitiId(String cityId) {
        return null;
    }
}
