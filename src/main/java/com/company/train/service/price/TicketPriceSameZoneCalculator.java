package com.company.train.service.price;

import com.company.train.constant.Constant;
import com.company.train.helper.ZoneByStationHelper;

import static com.company.train.constant.Constant.ticket_prices;

public class TicketPriceSameZoneCalculator {
    private final ZoneByStationHelper zoneByStationHelper = new ZoneByStationHelper();
    public double calculate(String stationStart, String stationEnd) {
        Integer zone = zoneByStationHelper.getZonesByStationEndPoint(stationStart, stationEnd).get(0);
        return ticket_prices[zone][zone] * Constant.CENT;
    }
}
