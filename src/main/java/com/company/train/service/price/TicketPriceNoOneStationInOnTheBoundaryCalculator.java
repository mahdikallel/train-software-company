package com.company.train.service.price;

import com.company.train.helper.ZoneByStationHelper;

import java.util.List;

import static com.company.train.constant.Constant.CENT;
import static com.company.train.constant.Constant.ticket_prices;

public class TicketPriceNoOneStationInOnTheBoundaryCalculator {
    private final ZoneByStationHelper zoneByStationHelper = new ZoneByStationHelper();


    public double calculate(String stationStart, String stationEnd) {
        List<Integer> zone = zoneByStationHelper.getZonesByStationEndPoint(stationStart, stationEnd);
        return ticket_prices[zone.get(0)][zone.get(1)] * CENT;
    }

}
