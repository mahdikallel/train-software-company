package com.company.train.service;

import com.company.train.domain.CustomerJourney;
import com.company.train.domain.CustomerSummary;
import com.company.train.domain.Tap;
import com.company.train.service.price.TripPricingService;
import com.company.train.service.trip.TripCreatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CustomerSummaryServiceTest {
    private final TripPricingService tripPricingService = new TripPricingService();
    private final TripCreatorService tripCreatorService = new TripCreatorService(tripPricingService);
    private final CustomerSummaryService customerSummaryService = new CustomerSummaryService(tripCreatorService);

    @Test
    void should_sort_trip_by_timestamp_and_group_trips_by_customer_id() {

        // given
        int customerId_3 = 3;
        int customerId_4 = 4;

        CustomerJourney customerJourney = new CustomerJourney(List.of(
                new Tap(3, customerId_3, "H"),
                new Tap(27, customerId_3, "E"),
                new Tap(30, customerId_3, "E"),
                new Tap(35, customerId_3, "A"),

                new Tap(41L, customerId_4, "A"),
                new Tap(47L, customerId_4, "I"),
                new Tap(70L, customerId_4, "E"),
                new Tap(81L, customerId_4, "F")

        ));

        // when
        List<CustomerSummary> customerSummaries = customerSummaryService.groupTapsByCustomerId(customerJourney);

        // then
        Assertions.assertEquals(2, customerSummaries.size());
        Assertions.assertEquals(customerId_3, customerSummaries.get(0).getCustomerId());
        Assertions.assertEquals(440, customerSummaries.get(0).getTotalCostInCents());
        Assertions.assertEquals(2, customerSummaries.get(0).getTrips().size());
        Assertions.assertEquals("H", customerSummaries.get(0).getTrips().get(0).getStationStart());
        Assertions.assertEquals("E", customerSummaries.get(0).getTrips().get(0).getStationEnd());
        Assertions.assertEquals(3, customerSummaries.get(0).getTrips().get(0).getStartedJourneyAt());
        Assertions.assertEquals(200, customerSummaries.get(0).getTrips().get(0).getCostInCents());
        Assertions.assertEquals(4, customerSummaries.get(0).getTrips().get(0).getZoneFrom());
        Assertions.assertEquals(3, customerSummaries.get(0).getTrips().get(0).getZoneTo());


    }

}
