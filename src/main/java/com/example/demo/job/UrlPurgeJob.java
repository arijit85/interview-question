package com.example.demo.job;


import com.example.demo.persistence.UrlRepository;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UrlPurgeJob implements Job {

    @Autowired
    UrlRepository urlRepository;

    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("Hello from Job One!");
        urlRepository.removeOlderThan(System.currentTimeMillis() -30);
    }
}
