package com.example.demo.batch001.reader;

import com.example.demo.dto.Batch001Dto;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@Component("Batch001Reader")
@StepScope
@Slf4j
public class Batch001Reader implements ItemReader<Batch001Dto> {

    private boolean isFirst = true;

    private List<Batch001Dto> data = new ArrayList<>();

    private int dataIndex = 0;

    @Override
    public Batch001Dto read() {

        if (isFirst) {
            log.info("初次进入reader");
            data = new ArrayList<>();
            data.add(new Batch001Dto("1", "1"));
            data.add(new Batch001Dto("2", "2"));
            data.add(new Batch001Dto("3", "3"));
            data.add(new Batch001Dto("4", "4"));
            data.add(new Batch001Dto("5", "5"));
            data.add(new Batch001Dto("6", "6"));
            data.add(new Batch001Dto("7", "7"));
            data.add(new Batch001Dto("8", "8"));
            data.add(new Batch001Dto("9", "9"));
            data.add(new Batch001Dto("10", "10"));
            isFirst = false;
        }

        if (dataIndex < data.size()) {
            return data.get(dataIndex ++);
        }
        return null;
    }
}
