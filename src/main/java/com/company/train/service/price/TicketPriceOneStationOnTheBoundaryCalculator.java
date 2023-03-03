package com.company.train.service.price;

import com.company.train.helper.ZoneByStationHelper;

import java.util.ArrayList;
import java.util.List;

import static com.company.train.constant.Constant.CENT;
import static com.company.train.constant.Constant.ticket_prices;

public class TicketPriceOneStationOnTheBoundaryCalculator {

    private final ZoneByStationHelper zoneByStationHelper = new ZoneByStationHelper();

    public Double calculate(String stationStart, String stationEnd) {
        List<Integer> stationStartZones = zoneByStationHelper.getStationBoundaryZones(stationStart);
        List<Integer> stationEndZones = zoneByStationHelper.getStationBoundaryZones(stationEnd);
        List<Double> lowestPrices = new ArrayList<>();
        List<Integer> stationToIterate;
        int stationNotOnTheBoundary;
        if (stationStartZones.size() < stationEndZones.size()) {
            stationToIterate = stationEndZones;
            stationNotOnTheBoundary = stationStartZones.get(0);
        } else {
            stationToIterate = stationStartZones;
            stationNotOnTheBoundary = stationEndZones.get(0);
        }

        for (Integer integer : stationToIterate) {
            lowestPrices.add(ticket_prices[stationNotOnTheBoundary][integer] * CENT);
        }
        return lowestPrices.stream().min(Double::compareTo).orElse(0D);
    }
}
