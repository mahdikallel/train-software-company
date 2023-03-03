package com.company.train.service.price;

import com.company.train.helper.ZoneByStationHelper;

public class TripPricingService {
    private final ZoneByStationHelper zoneByStationHelper = new ZoneByStationHelper();
    private final TicketPriceSameZoneCalculator ticketPriceSameZoneCalculator = new TicketPriceSameZoneCalculator();

    private final TicketPriceNoOneStationInOnTheBoundaryCalculator ticketPriceNoOneStationInOnTheBoundaryCalculator = new TicketPriceNoOneStationInOnTheBoundaryCalculator();

    private final TicketPriceOneStationOnTheBoundaryCalculator calculateTicketPriceOneStationOnTheBoundary= new TicketPriceOneStationOnTheBoundaryCalculator();


    public double calculatePrice(String stationStart, String stationEnd) {
        if (zoneByStationHelper.isStationsInSameZone(stationStart, stationEnd)) {
            return ticketPriceSameZoneCalculator.calculate(stationStart, stationEnd);
        }
        if (zoneByStationHelper.isNoOneStationIsOnTheBoundary(stationStart, stationEnd)) {
            return ticketPriceNoOneStationInOnTheBoundaryCalculator.calculate(stationStart, stationEnd);
        }
        if (zoneByStationHelper.atLeastOneStationOnTheBoundary(stationStart, stationEnd)) {
            return calculateTicketPriceOneStationOnTheBoundary.calculate(stationStart, stationEnd);
        }
        return 0;
    }
}
