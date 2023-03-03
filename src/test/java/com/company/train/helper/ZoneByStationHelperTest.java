package com.company.train.helper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class ZoneByStationHelperTest {
    public static Stream<Arguments> generateStationZoneData() {
        return Stream.of(
                Arguments.of("A", List.of(1)),
                Arguments.of("B", List.of(1)),
                Arguments.of("C", List.of(2, 3)),
                Arguments.of("D", List.of(2)),
                Arguments.of("E", List.of(2, 3)),
                Arguments.of("F", List.of(3, 4)),
                Arguments.of("G", List.of(4)),
                Arguments.of("H", List.of(4)),
                Arguments.of("I", List.of(4))
        );
    }

    @ParameterizedTest
    @MethodSource("generateStationZoneData")
    public void should_return_true_when_at_least_one_station_on_the_boundary(String station, List<Integer> zones) {
        //given

        //when
        Map<String, List<Integer>> stationZoneByStationMap = ZoneByStationHelper.STATION_ZONE_BY_STATION_MAP;

        //then
        Assertions.assertEquals(
                stationZoneByStationMap.get(station),
                zones
        );
    }


}
