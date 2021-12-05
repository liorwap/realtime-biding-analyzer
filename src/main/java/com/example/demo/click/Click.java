package com.example.demo.click;

import com.example.demo.metadata.MetaData;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Click extends MetaData {

    @CsvBindByPosition(position = 2)
    private int time;
}
