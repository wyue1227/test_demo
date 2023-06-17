package com.example.demo.batch001.writer;

import com.example.demo.dto.Batch001Dto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("Batch001Writer")
@StepScope
@Slf4j
public class Batch001Writer implements ItemWriter<Batch001Dto> {
    @Override
    public void write(Chunk<? extends Batch001Dto> chunk) throws Exception {
        log.info("Batch001Writer--start");
        log.info("Batch001Writer--end");
    }
}
