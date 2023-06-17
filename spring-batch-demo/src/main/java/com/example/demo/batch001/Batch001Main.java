package com.example.demo.batch001;

import com.example.demo.batch001.processor.Batch001Processor;
import com.example.demo.batch001.reader.Batch001Reader;
import com.example.demo.batch001.tasklet.Batch001Tasklet;
import com.example.demo.batch001.writer.Batch001Writer;
import com.example.demo.dto.Batch001Dto;
import com.example.demo.parent.BaseBatch;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class Batch001Main extends BaseBatch {
    
    @Autowired
    @Qualifier("Batch001Reader")
    private Batch001Reader reader;

    @Autowired
    @Qualifier("Batch001Processor")
    private Batch001Processor processor;

    @Autowired
    @Qualifier("Batch001Writer")
    private Batch001Writer writer;

    @Autowired
    @Qualifier("Batch001Tasklet")
    private Batch001Tasklet tasklet;
    
    @Bean("Batch001Job")
    public Job job(JobRepository jobRepository) {
        return new JobBuilder("Batch001Job", jobRepository).start(step1(jobRepository)).next(step2(jobRepository)).build();
    }

    @Bean
    public Step step1(JobRepository jobRepository) {
        return new StepBuilder("Batch001JobStep1", jobRepository).<Batch001Dto, Batch001Dto>chunk(10, getTransactionManager()).reader(reader).processor(processor).writer(writer).build();
    }

    @Bean
    public Step step2(JobRepository jobRepository) {
        return new StepBuilder("Batch001JobStep2", jobRepository).tasklet(tasklet, getTransactionManager()).build();
    }

}