package com.example.demo.click;

import com.example.demo.dataloader.DataLoaderService;

import java.util.Set;

public record ClickQuery(DataLoaderService dataLoaderService) {

    public long getNumOfClicks(Set<String> sessionsIds) {
        return dataLoaderService.getClicksArray().stream()
                .filter(click -> sessionsIds.contains(click.getSessionId()))
                .count();
    }
}
