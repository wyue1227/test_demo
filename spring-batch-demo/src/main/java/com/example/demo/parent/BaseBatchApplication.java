package com.example.demo.parent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
public abstract class BaseBatchApplication {

    protected static void beforeRun() {
        log.info("batch start");
    }

    protected static void afterRun(ConfigurableApplicationContext context) {
        log.info("batch end" + context.getApplicationName());
    }

    protected static void doMain(Class<?> primarySource, String[] args) {
        beforeRun();
        ConfigurableApplicationContext context = null;
        int exitCode = 0;
        try{
            context = SpringApplication.run(primarySource, args);
            afterRun(context);
        } catch (Exception e) {
            log.info("error: " + e);
        }
        if (context == null) {
            exitCode = -10;
        } else {
            exitCode = SpringApplication.exit(context);
        }
        System.exit(exitCode);
    }
}
