package com.example.demo.metadata;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class MetaData {
    @CsvBindByPosition(position = 0)
    private String timestamp;

    @CsvBindByPosition(position = 1)
    private String sessionId;
}
