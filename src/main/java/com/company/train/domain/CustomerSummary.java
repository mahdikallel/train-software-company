package com.company.train.domain;

import java.util.List;

public class CustomerSummary {
    private final int customerId;
    private final int totalCostInCents;
    private final List<Trip> trips;

    public CustomerSummary(int customerId, int totalCostInCents, List<Trip> trips) {
        this.customerId = customerId;
        this.totalCostInCents = totalCostInCents;
        this.trips = trips;
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public int getTotalCostInCents() {
        return totalCostInCents;
    }
}
