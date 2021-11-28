package com.example.demo.request;

import com.example.demo.metadata.MetaData;
import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

@Getter
@Setter
public class Request extends MetaData {

    @CsvBindByPosition(position = 2)
    private String partnerName;

    @CsvBindByPosition(position = 3)
    private String userId;

    @CsvBindByPosition(position = 4)
    private float bid;

    @CsvBindByPosition(position = 5)
    private boolean win;
}
