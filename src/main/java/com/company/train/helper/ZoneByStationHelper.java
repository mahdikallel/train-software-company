package com.company.train.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZoneByStationHelper {


    public static final Map<String, List<Integer>> STATION_ZONE_BY_STATION_MAP = new HashMap<>() {
        {
            put("A", List.of(1));
            put("B", List.of(1));
            put("C", List.of(2, 3));
            put("D", List.of(2));
            put("E", List.of(2, 3));
            put("F", List.of(3, 4));
            put("G", List.of(4));
            put("H", List.of(4));
            put("I", List.of(4));
        }
    };
}
