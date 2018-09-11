package com.echo.helloworld.controller;

import com.echo.helloworld.service.GateWayService;
import com.echo.helloworld.vo.City;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private GateWayService gateWayService;

    @RequestMapping("/city_id/{cityId}")
    public ModelAndView reportWeatherInformation(@PathVariable String cityId, Model model) {
        model.addAttribute("weatherInfo", gateWayService.getWeatherInfoByCitiId(cityId));
        List<City> cities = gateWayService.getCities();
        model.addAttribute("cities", cities);
        model.addAttribute("cityId", cityId);
        return new ModelAndView("report/weather", "reportModel", model);
    }

    @HystrixCommand(fallbackMethod = "getCitiesFailBack")
    @RequestMapping("/cities")
    public String getCities(){
        return gateWayService.getCities().toString();
    }

    public String getCitiesFailBack(){
        return "sorry,no service available.";
    }

}
