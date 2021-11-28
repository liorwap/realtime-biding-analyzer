package com.example.demo.request;

import com.example.demo.dataloader.DataLoaderService;

import java.util.Set;
import java.util.stream.Collectors;

public record RequestQuery(DataLoaderService dataLoaderService) {

    public long getNumOfRequests(String userId) {
        return dataLoaderService.getRequestsArray().stream()
                .filter(request -> request.getUserId().equals(userId))
                .count();
    }

    public Set<String> getUserSessions(String userId) {
        return dataLoaderService.getRequestsArray().stream()
                .filter(request -> request.getUserId().equals(userId))
                .map(Request::getSessionId)
                .collect(Collectors.toSet());
    }

    public float getTotalPriceForBids(String userId) {
        return (float) dataLoaderService.getRequestsArray().stream()
                .filter(request -> request.getUserId().equals(userId) && request.isWin())
                .mapToDouble(Request::getBid)
                .sum();
    }

    public long getNumOfWinningBids(String userId) {
        return dataLoaderService.getRequestsArray().stream()
                .filter(request -> request.getUserId().equals(userId) && request.isWin())
                .count();
    }

    public float getAveragePriceForBid(String userId) {
        return getTotalPriceForBids(userId) / getNumOfWinningBids(userId);
    }
}
