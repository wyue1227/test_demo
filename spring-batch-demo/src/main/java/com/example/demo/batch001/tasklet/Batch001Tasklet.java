package com.example.demo.batch001.tasklet;

import com.example.demo.parent.BaseTasklet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component("Batch001Tasklet")
@StepScope
public class Batch001Tasklet extends BaseTasklet {
    @Override
    public RepeatStatus doExecute(StepContribution contribution, ChunkContext chunkContext) {

        log.info("Batch001Tasklet start");



        log.info("Batch001Tasklet end");
        return RepeatStatus.FINISHED;
    }
}
