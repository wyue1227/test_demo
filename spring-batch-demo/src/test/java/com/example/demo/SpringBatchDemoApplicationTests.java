package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.batch001.Batch001Main;
import com.example.demo.batch001.processor.Batch001Processor;
import com.example.demo.batch001.reader.Batch001Reader;
import com.example.demo.batch001.tasklet.Batch001Tasklet;
import com.example.demo.batch001.writer.Batch001Writer;
import com.example.demo.config.DataSourceConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ContextConfiguration(classes = {SpringBatchDemoApplication.class, DataSourceConfiguration.class, Batch001Tasklet.class, Batch001Reader.class, Batch001Processor.class, Batch001Writer.class})
@SpringBatchTest
@SpringJUnitConfig(Batch001Main.class)
class SpringBatchDemoApplicationTests {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    @Qualifier("Batch001Job")
    private Job job;
    
    @Test
    void test_Batch001_N01() throws Exception {
        jobLauncherTestUtils.setJob(job);
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        assertThat(jobExecution.getExitStatus()).isEqualTo(ExitStatus.COMPLETED);
    }

}
