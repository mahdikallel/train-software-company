package com.company.train.service.trip;

import com.company.train.domain.Tap;
import com.company.train.domain.Trip;
import com.company.train.helper.ZoneByStationHelper;
import com.company.train.service.price.TripPricingService;

import java.util.ArrayList;
import java.util.List;

public class TripCreatorService {

    private final TripPricingService tripPricingService = new TripPricingService();
    private final ZoneByStationHelper zoneByStationHelper = new ZoneByStationHelper();

    public List<Trip> create(List<Tap> taps) {
        List<Trip> trips = new ArrayList<>();
        for (int i = 0; i < taps.size(); i = i + 2) {
            Tap firstTap = taps.get(i);
            Tap lastTap = taps.get(i + 1);
            double tripCost = tripPricingService.calculatePrice(firstTap.getStation(), lastTap.getStation());
            int zoneFrom = zoneByStationHelper.getZoneByStation(firstTap.getStation());
            int zoneTo = zoneByStationHelper.getZoneByStation(lastTap.getStation());
            trips.add(
                    new Trip(firstTap.getStation(), lastTap.getStation(), firstTap.getUnixTimestamp(), tripCost, zoneFrom, zoneTo)
            );
        }
        return trips;
    }
}
