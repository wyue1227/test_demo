package com.example.demo.batch001.processor;

import com.example.demo.dto.Batch001Dto;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("Batch001Processor")
@StepScope
public class Batch001Processor implements ItemProcessor<Batch001Dto, Batch001Dto> {
    @Override
    public Batch001Dto process(Batch001Dto batch001Dto) throws Exception {

        Batch001Dto result = new Batch001Dto();
        result.setFirstName("0" + batch001Dto.getFirstName());
        result.setLastName("0" + batch001Dto.getLastName());
        return result;
    }
}
