package com.echo.helloworld.jobs;

import com.echo.helloworld.service.WeatherService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class WeatherFreshTask extends QuartzJobBean {

    @Autowired
    private WeatherService weatherService;

    private Logger logger = LoggerFactory.getLogger(WeatherFreshTask.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        weatherService.syncWeatherOfListOfCities();
    }
}
