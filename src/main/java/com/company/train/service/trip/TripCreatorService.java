package com.company.train.service.trip;

import com.company.train.domain.Tap;
import com.company.train.domain.Trip;
import com.company.train.service.price.Price;
import com.company.train.service.price.TripPricingService;

import java.util.ArrayList;
import java.util.List;

public class TripCreatorService {

    private final TripPricingService tripPricingService;

    public TripCreatorService(TripPricingService tripPricingService) {
        this.tripPricingService = tripPricingService;
    }

    public List<Trip> create(List<Tap> taps) {
        List<Trip> trips = new ArrayList<>();
        for (int i = 0; i < taps.size(); i = i + 2) {
            Tap firstTap = taps.get(i);
            Tap lastTap = taps.get(i + 1);
            Price price = tripPricingService.calculatePrice(firstTap.getStation(), lastTap.getStation());
            int tripCost = price.getPrice();
            int zoneFrom = price.getZoneStart();
            int zoneTo = price.getZoneEnd();
            trips.add(
                    new Trip(firstTap.getStation(), lastTap.getStation(), firstTap.getUnixTimestamp(), tripCost, zoneFrom, zoneTo)
            );
        }
        return trips;
    }
}
