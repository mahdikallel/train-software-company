package com.company.train.domain;

public class Trip {

    private final String stationStart;
    private final String stationEnd;
    private final long startedJourneyAt;
    private final int costInCents;
    private final int zoneFrom;
    private final int zoneTo;

    public Trip(String stationStart, String stationEnd, long startedJourneyAt, int costInCents, int zoneFrom, int zoneTo) {
        this.stationStart = stationStart;
        this.stationEnd = stationEnd;
        this.startedJourneyAt = startedJourneyAt;
        this.costInCents = costInCents;
        this.zoneFrom = zoneFrom;
        this.zoneTo = zoneTo;
    }

    public String getStationStart() {
        return stationStart;
    }

    public String getStationEnd() {
        return stationEnd;
    }

    public long getStartedJourneyAt() {
        return startedJourneyAt;
    }


    public int getCostInCents() {
        return costInCents;
    }

    public int getZoneFrom() {
        return zoneFrom;
    }

    public int getZoneTo() {
        return zoneTo;
    }
}
