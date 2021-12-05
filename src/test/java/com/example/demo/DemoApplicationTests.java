package com.example.demo;

import com.example.demo.dataloader.DataLoaderService;
import com.example.demo.request.Request;
import com.example.demo.userstats.UserStats;
import com.example.demo.userstats.UserStatsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserStatsController userStatsController;

    @Autowired
    private DataLoaderService dataLoaderService;

    @Test
    void contextLoads() {
        assert userStatsController != null;
        assert dataLoaderService != null;
    }
    @Test
    void sampleUserCheck() {
        UserStats sampleUser = userStatsController.getUserStats("0fdca2e7-c5e5-4873-8053-ac106f4c1fc2");
        assert sampleUser.getNumOfRequests() == 8;
        assert sampleUser.getNumOfImpressions() == 3;
        assert sampleUser.getNumOfClicks() == 2;
        assert Math.abs(sampleUser.getAveragePriceForBid() - 4.786667) < 0.1;
    }
    @Test
    void userNotFoundCheck() {

    }
    @Test
    void loadCheck() {
//        Set<String> allUsersIds = dataLoaderService.getRequestsArray()
//                .stream().map(Request::getUserId)
//                .collect(Collectors.toSet());
//        for(String userId : allUsersIds){
//            userStatsController.getUserStats(userId);
//        }
    }
}
