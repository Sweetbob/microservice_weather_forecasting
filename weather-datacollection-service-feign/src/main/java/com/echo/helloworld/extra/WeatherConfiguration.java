package com.echo.helloworld.extra;

import com.echo.helloworld.jobs.WeatherFreshTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherConfiguration {

    private static final int SYNC_TIME = 1800;

    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob().ofType(WeatherFreshTask.class)
                .storeDurably()
                .withIdentity("weatherFreshTask")
                .build();
    }

    @Bean
    public Trigger trigger(JobDetail job) {
        ScheduleBuilder simpleSchedule = SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(SYNC_TIME);
        return TriggerBuilder.newTrigger().forJob(jobDetail())
                .withIdentity("weatherFreshTaskTrigger")
                .withSchedule(simpleSchedule)
                .build();
    }

}
