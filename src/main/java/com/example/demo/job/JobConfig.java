package com.example.demo.job;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {

    @Bean
    public JobDetail urlPurgeJobDetails() {
        return JobBuilder.newJob(UrlPurgeJob.class).withIdentity("urlPurgeJob").storeDurably().build();
    }
    @Bean
    public Trigger urlPurgeJobTrigger(JobDetail urlPurgeJobDetails) {
        return TriggerBuilder.newTrigger()
                .forJob(urlPurgeJobDetails)
                .withIdentity("urlPurgeTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 * * ? * *"))
                .build();
    }
}
