package com.example.demo.impression;

import com.example.demo.dataloader.DataLoaderService;

import java.util.Set;

public record ImpressionQuery(DataLoaderService dataLoaderService) {

    public long getNumOfImpressions(Set<String> sessionsIds) {
        return dataLoaderService.getImpressionsArray().stream()
                .filter(impression -> sessionsIds.contains(impression.getSessionId()))
                .count();
    }
}
