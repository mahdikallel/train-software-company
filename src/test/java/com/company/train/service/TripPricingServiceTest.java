package com.company.train.service;

import com.company.train.service.price.TripPricingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TripPricingServiceTest {

    TripPricingService tripPricingService = new TripPricingService();

    @Test
    public void should_price_be_equal_240_when_travel_within_zone_1() {
        // given
        String stationStart = "A";
        String stationEnd = "B";

        //when
        double price = tripPricingService.calculatePrice(stationStart, stationEnd);

        //then
        Assertions.assertEquals(240D, price);
    }

    @Test
    public void should_price_be_equal_200_when_travel_within_zone_4() {
        // given
        String stationStart = "H";
        String stationEnd = "I";

        //when
        double price = tripPricingService.calculatePrice(stationStart, stationEnd);

        //then
        Assertions.assertEquals(200D, price);
    }

    @Test
    public void should_price_be_equal_300_when_travel_from_1_to_4() {
        // given
        String stationStart = "A";
        String stationEnd = "G";

        //when
        double price = tripPricingService.calculatePrice(stationStart, stationEnd);

        //then
        Assertions.assertEquals(300D, price);
    }

    @Test
    public void should_price_be_equal_240_when_travel_from_Zone_1_to_Zone_2() {
        // given
        String stationStart = "B";
        String stationEnd = "D";

        //when
        double price = tripPricingService.calculatePrice(stationStart, stationEnd);

        //then
        Assertions.assertEquals(240D, price);
    }

    @Test
    public void should_price_be_equal_240_when_travel_from_station_Zone1_to_station_on_boundary_of_Zone2_and_Zone3() {
        // given
        String stationStart = "A";
        String stationEnd = "E";// on the boundary zone 2 and zone 3

        //when
        double price = tripPricingService.calculatePrice(stationStart, stationEnd);

        //then
        Assertions.assertEquals(240D, price);
    }


    @Test
    public void should_price_be_equal_240_when_travel_from_station_on_boundary_of_Zone2_and_Zone3_to_station_Zone1() {
        // given
        String stationStart = "E";  // on the boundary zone 2 and zone 3
        String stationEnd = "A";
        //when

        double price = tripPricingService.calculatePrice(stationStart, stationEnd);

        //then
        Assertions.assertEquals(240D, price);
    }

    @Test
    public void should_price_be_equal_280_when_travel_from_station_on_boundary_of_Zone2_and_Zone3_to_station_Zone2() {
        // given
        String stationStart = "E";  // on the boundary zone 2 and zone 3
        String stationEnd = "D";
        //when

        double price = tripPricingService.calculatePrice(stationStart, stationEnd);

        //then
        Assertions.assertEquals(280D, price);
    }

    @Test
    public void should_price_be_equal_200_when_travel_from_station_Zone4_to_station_on_boundary_of_Zone2_and_Zone3() {
        // given
        String stationStart = "H";  // on the boundary zone 2 and zone 3
        String stationEnd = "E";
        //when

        double price = tripPricingService.calculatePrice(stationStart, stationEnd);

        //then
        Assertions.assertEquals(200D, price);
    }

    @Test
    public void should_price_be_equal_280_when_travel_from_station_Zone2_to_station_on_boundary_of_Zone3_and_Zone4() {
        // given
        String stationStart = "D";  // on the boundary zone 2 and zone 3
        String stationEnd = "F";
        //when

        double price = tripPricingService.calculatePrice(stationStart, stationEnd);

        //then
        Assertions.assertEquals(280D, price);
    }
}
