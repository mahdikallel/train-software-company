package com.company.train.helper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class ZoneByStationHelperTest {

    ZoneByStationHelper zoneByStationHelper = new ZoneByStationHelper();

    @Test
    public void should_return_zone_1_when_start_station_is_A_and_end_station_is_B() {
        //given

        //when
        List<Integer> zone = zoneByStationHelper.getZonesByStationEndPoint("A","B");

        //then
        int expectedZone = 1;
        Assertions.assertEquals(1, zone.size());
        Assertions.assertEquals(expectedZone, zone.get(0));
    }

    @Test
    public void should_return_zone_1_zone_2_zone_3_when_start_station_is_A_and_end_station_is_C() {
        //given

        //when
        List<Integer> zone = zoneByStationHelper.getZonesByStationEndPoint("A","C");

        //then
        Assertions.assertEquals(3, zone.size());
        Assertions.assertEquals(1, zone.get(0));
        Assertions.assertEquals(2, zone.get(1));
        Assertions.assertEquals(3, zone.get(2));
    }

    @Test
    public void should_return_zone_1_zone_2_when_start_station_is_A_and_end_station_is_D() {
        //given

        //when
        List<Integer> zone = zoneByStationHelper.getZonesByStationEndPoint("D","A");

        //then
        Assertions.assertEquals(2, zone.size());
        Assertions.assertEquals(1, zone.get(0));
        Assertions.assertEquals(2, zone.get(1));
    }

    @Test
    public void should_return_true_when_start_station_and_end_station_is_in_same_zone() {
        //given

        //when
        boolean stationsInSameZone = zoneByStationHelper.isStationsInSameZone("B", "A");

        //then
        Assertions.assertTrue(stationsInSameZone);
    }

    @ParameterizedTest
    @CsvSource( value = {
            "A:D", "A:H", "A:G", "A:I",
            "B:D", "B:H", "B:G", "B:I",
            "D:B", "D:H", "D:G", "D:I"
    }, delimiter = ':')
    public void should_return_true_when_no_one_station_on_the_boundary(String stationStart, String stationEnd) {
        //given

        //when
        boolean stationsInSameZone = zoneByStationHelper.isNoOneStationIsOnTheBoundary(stationStart, stationEnd);

        //then
        Assertions.assertTrue(stationsInSameZone);
    }

    @ParameterizedTest
    @CsvSource( value = {
            "A:E", "A:C", "A:F",
            "B:E", "B:C", "B:F",
            "D:F",
    }, delimiter = ':')
    public void should_return_true_when_at_least_one_station_on_the_boundary(String stationStart, String stationEnd) {
        //given

        //when
        boolean stationsInSameZone = zoneByStationHelper.atLeastOneStationOnTheBoundary(stationStart, stationEnd);

        //then
        Assertions.assertTrue(stationsInSameZone);
    }


}
