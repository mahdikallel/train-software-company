package com.company.train.service.price;

import com.company.train.constant.Constant;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static com.company.train.helper.ZoneByStationHelper.STATION_ZONE_BY_STATION_MAP;

public class TripPricingService {
    public Price calculatePrice(String stationStart, String stationEnd) {
        List<Integer> startZones = STATION_ZONE_BY_STATION_MAP.get(stationStart);
        List<Integer> endZones = STATION_ZONE_BY_STATION_MAP.get(stationEnd);
        return startZones
                .stream()
                .flatMap(start -> generatePossiblePrices(endZones, start))
                .min(Comparator.comparingDouble(Price::getPrice))
                .orElseThrow(() -> new IllegalArgumentException("station does not exist ! please enter a valid station"));
    }
    private static Stream<Price> generatePossiblePrices(List<Integer> endZones, Integer start) {
        return endZones
                .stream()
                .map(end -> new Price(start, end, (int) (Constant.ticket_prices[start][end] * Constant.CENT)));
    }
}
