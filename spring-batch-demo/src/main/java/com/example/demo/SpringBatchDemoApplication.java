package com.example.demo;

import com.example.demo.parent.BaseBatchApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringBatchDemoApplication extends BaseBatchApplication {

    public static void main(String[] args) {
        doMain(SpringBatchDemoApplication.class, args);
    }

}
