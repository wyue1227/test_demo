package com.example.demo.parent;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;

@Slf4j
public abstract class BaseTasklet implements Tasklet {

    @Getter
    private StepContribution stepContribution;

    @Getter
    private ChunkContext chunkContext;

    private int index = 1;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        String stepName = chunkContext.getStepContext().getStepName();
        log.info("Batch Tasklet Step start {} - {}", stepName, index);

        this.stepContribution = contribution;
        this.chunkContext = chunkContext;

        try {
            return this.doExecute(contribution, chunkContext);
        } catch (Exception e) {
            log.info("例外：" + e);
            throw e;
        } finally {
            log.info("Batch Tasklet End {} - {}", stepName, index);
            index ++;
        }

    }

    public void setExitStatus(ExitStatus exitStatus) {
        this.stepContribution.setExitStatus(exitStatus);
    }

    public ExecutionContext getExecutionContext() {
        return this.chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
    }

    public Object getTaskletJobParameter(String jobParamKey) {
        return this.chunkContext.getStepContext().getJobParameters().get(jobParamKey);
    }

    public abstract RepeatStatus doExecute(StepContribution contribution, ChunkContext chunkContext);
}
