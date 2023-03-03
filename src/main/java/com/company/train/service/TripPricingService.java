package com.company.train.service;

import com.company.train.helper.ZoneByStationHelper;

import java.util.ArrayList;
import java.util.List;

public class TripPricingService {

    private final double[][] ticket_prices = {
            {-1, -1, -1, -1, -1},
            {-1, 2.4, 2.4, 2.8, 3},
            {-1, 2.4, 2.4, 2.8, 3},
            {-1, 2.8, 2.8, 2, 2},
            {-1, 3, 3, 2, 2}
    };
    private final double CENT = 100;
    private final ZoneByStationHelper zoneByStationHelper;

    public TripPricingService(ZoneByStationHelper zoneByStationHelper) {
        this.zoneByStationHelper = zoneByStationHelper;
    }

    public double calculatePrice(String stationStart, String stationEnd) {
        if (zoneByStationHelper.isStationsInSameZone(stationStart, stationEnd)) {
            Integer zone = zoneByStationHelper.getZonesByStationEndPoint(stationStart, stationEnd).get(0);
            return ticket_prices[zone][zone] * CENT;
        }
        if (zoneByStationHelper.isNoOneStationIsOnTheBoundary(stationStart, stationEnd)) {
            List<Integer> zone = zoneByStationHelper.getZonesByStationEndPoint(stationStart, stationEnd);
            return ticket_prices[zone.get(0)][zone.get(1)] * CENT;
        }
        if (zoneByStationHelper.atLeastOneStationOnTheBoundary(stationStart, stationEnd)) {
            List<Integer> zones = zoneByStationHelper.getZonesByStationEndPoint(stationStart, stationEnd);
            List<Double> lowestPrices = new ArrayList<>();
            Integer startZone = zones.get(0);
            for (int i = 1; i < zones.size(); i++) {
                lowestPrices.add(ticket_prices[startZone][zones.get(i)] * CENT);
            }
            return lowestPrices.stream().min(Double::compareTo).orElse(0D);
        }
        return 0;
    }
}
