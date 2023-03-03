package com.company.train.domain;

public class Tap {

    private final long unixTimestamp;
    private final int customerId;
    private final String station;

    public Tap(long unixTimestamp, int customerId, String station) {
        this.unixTimestamp = unixTimestamp;
        this.customerId = customerId;
        this.station = station;
    }

    public long getUnixTimestamp() {
        return unixTimestamp;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getStation() {
        return station;
    }
}
