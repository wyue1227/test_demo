package com.example.demo.config;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {

    @Bean
    public JobLauncherTestUtils JobLauncherTestUtils() {
        return new JobLauncherTestUtils();
    }

}
