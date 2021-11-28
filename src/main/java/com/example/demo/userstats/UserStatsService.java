package com.example.demo.userstats;

import com.example.demo.click.ClickQuery;
import com.example.demo.dataloader.DataLoaderService;
import com.example.demo.impression.ImpressionQuery;
import com.example.demo.request.RequestQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
public class UserStatsService {

    private final RequestQuery requestQuery;
    private final ImpressionQuery impressionQuery;
    private final ClickQuery clickQuery;

    public UserStatsService(DataLoaderService dataLoaderService) {
        this.requestQuery = new RequestQuery(dataLoaderService);
        this.impressionQuery = new ImpressionQuery(dataLoaderService);
        this.clickQuery = new ClickQuery(dataLoaderService);
    }

    public UserStats getUserStats(String userId){
        log.info("user stats service called with user id: {}", userId);

        long numOfRequests = requestQuery.getNumOfRequests(userId);

        Set<String> sessionsIds = requestQuery.getUserSessions(userId);
        long numOfImpressions = impressionQuery.getNumOfImpressions(sessionsIds);
        long numOfClicks = clickQuery.getNumOfClicks(sessionsIds);

        float averagePriceForBid = requestQuery.getAveragePriceForBid(userId);
        UserStats userStatsResult = new UserStats(numOfRequests, numOfImpressions, numOfClicks, averagePriceForBid);

        log.info("returned user stats: {}", userStatsResult);
        return userStatsResult;
    }
}
