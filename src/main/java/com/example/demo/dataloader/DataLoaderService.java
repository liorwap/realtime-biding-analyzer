package com.example.demo.dataloader;

import com.example.demo.click.Click;
import com.example.demo.impression.Impression;
import com.example.demo.request.Request;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Service
@Getter
@Setter
public class DataLoaderService {

    private List<Click> clicksArray;
    private List<Impression> impressionsArray;
    private List<Request> requestsArray;

    private <T> List<T> loadCSV(String path, Class<T> classType) {
        log.info("loading {} file", path);
        try {
            Resource resource = new ClassPathResource(path);
            log.info(resource.getFilename());
            InputStream reader = resource.getInputStream();
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(new InputStreamReader(reader, StandardCharsets.UTF_8))
                    .withType(classType)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        } catch (IOException e) {
            log.error("failed to open {} : {}", path, e.getMessage());
        }
        return null;
    }

    public DataLoaderService(){
        requestsArray = loadCSV("data/requests.csv", Request.class);
        impressionsArray = loadCSV("data/impressions.csv", Impression.class);
        clicksArray = loadCSV("data/clicks.csv", Click.class);
    }
}
