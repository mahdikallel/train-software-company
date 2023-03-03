package com.company.train.service.trip;

import com.company.train.domain.Tap;
import com.company.train.domain.Trip;
import com.company.train.service.price.TripPricingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TripCreatorServiceTest {

    private final TripCreatorService tripCreatorService = new TripCreatorService(new TripPricingService());

    @Test
    void should_create_trip_from_taps() {
        // given
        List<Tap> tapList = List.of(
                new Tap(2L, 2, "B"),
                new Tap(3L, 2, "C"),
                new Tap(3L, 2, "H"),
                new Tap(10L, 2, "G"),
                new Tap(20L, 2, "D"),
                new Tap(65L, 2, "F")
        );

        // when
        List<Trip> trips = tripCreatorService.create(tapList);

        // then
        Assertions.assertEquals(3, trips.size());

        Assertions.assertEquals("B", trips.get(0).getStationStart());
        Assertions.assertEquals("C", trips.get(0).getStationEnd());
        Assertions.assertEquals(2, trips.get(0).getStartedJourneyAt());
        Assertions.assertEquals(240, trips.get(0).getCostInCents());
        Assertions.assertEquals(1, trips.get(0).getZoneFrom());
        Assertions.assertEquals(2, trips.get(0).getZoneTo());


        Assertions.assertEquals("H", trips.get(1).getStationStart());
        Assertions.assertEquals("G", trips.get(1).getStationEnd());
        Assertions.assertEquals(3, trips.get(1).getStartedJourneyAt());
        Assertions.assertEquals(200, trips.get(1).getCostInCents());
        Assertions.assertEquals(4, trips.get(1).getZoneFrom());
        Assertions.assertEquals(4, trips.get(1).getZoneTo());


        Assertions.assertEquals("D", trips.get(2).getStationStart());
        Assertions.assertEquals("F", trips.get(2).getStationEnd());
        Assertions.assertEquals(20, trips.get(2).getStartedJourneyAt());
        Assertions.assertEquals(280, trips.get(2).getCostInCents());
        Assertions.assertEquals(2, trips.get(2).getZoneFrom());
        Assertions.assertEquals(3, trips.get(2).getZoneTo());
    }
}
