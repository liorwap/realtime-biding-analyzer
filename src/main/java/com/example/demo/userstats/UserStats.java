package com.example.demo.userstats;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserStats {

    private long numOfRequests;
    private long numOfImpressions;
    private long numOfClicks;
    private float averagePriceForBid;

}
