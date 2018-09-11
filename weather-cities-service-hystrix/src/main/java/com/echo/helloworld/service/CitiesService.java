package com.echo.helloworld.service;

import com.echo.helloworld.utils.ExtraUtils;
import com.echo.helloworld.vo.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesService {

    public List<City> getCities(){
        return ExtraUtils.getListOfCities();
    }

}
