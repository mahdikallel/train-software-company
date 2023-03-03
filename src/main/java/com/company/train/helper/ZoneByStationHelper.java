package com.company.train.helper;

import java.util.*;

public class ZoneByStationHelper {

    public static final Map<Integer, List<String>> STATION_ZONE_MAP = new HashMap<>() {
        {
            put(1, List.of("A", "B"));
            put(2, List.of("C", "D", "E"));
            put(3, List.of("C", "E", "F"));
            put(4, List.of("F", "G", "H", "I"));
        }
    };


    public List<Integer> getZonesByStationEndPoint(String stationStart, String stationEnd) {
        Set<Integer> zones = new HashSet<>();
        for (Map.Entry<Integer, List<String>> entry : STATION_ZONE_MAP.entrySet()) {
            if (entry.getValue().stream().anyMatch(s -> s.equals(stationStart) || s.equals(stationEnd))) {
                zones.add(entry.getKey());
            }
        }
        return new ArrayList<>(zones);
    }

    public List<Integer> getStationBoundaryZones(String station) {
        Set<Integer> zones = new HashSet<>();
        for (Map.Entry<Integer, List<String>> entry : STATION_ZONE_MAP.entrySet()) {
            if (entry.getValue().stream().anyMatch(s -> s.equals(station) )) {
                zones.add(entry.getKey());
            }
        }
        return new ArrayList<>(zones);
    }

    public boolean isStationsInSameZone(String stationStart, String stationEnd) {
        return this.getZonesByStationEndPoint(stationStart, stationEnd).size() == 1;
    }

    public boolean isNoOneStationIsOnTheBoundary(String stationStart, String stationEnd) {
        return this.getZonesByStationEndPoint(stationStart, stationEnd).size() == 2;
    }

    public boolean atLeastOneStationOnTheBoundary(String stationStart, String stationEnd) {
        return this.getZonesByStationEndPoint(stationStart, stationEnd).size() == 3;
    }

    public Integer getZoneByStation(String station) {
        return STATION_ZONE_MAP.entrySet()
                .stream()
                .filter(integerListEntry -> integerListEntry.getValue().stream().anyMatch(s -> s.equals(station)))
                .map(Map.Entry::getKey)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Station not found in any zone"));
    }
}
