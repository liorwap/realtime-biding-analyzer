package com.example.demo.impression;

import com.example.demo.metadata.MetaData;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Impression extends MetaData {
    @CsvBindByPosition(position = 2)
    private int duration;
}
