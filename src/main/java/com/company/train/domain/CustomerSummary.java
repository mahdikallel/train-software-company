package com.company.train.domain;

import java.util.List;

public class CustomerSummary {
    private final int customerId;
    private final double totalCostInCents;
    private final List<Trip> trips;

    public CustomerSummary(int customerId, double totalCostInCents, List<Trip> trips) {
        this.customerId = customerId;
        this.totalCostInCents = totalCostInCents;
        this.trips = trips;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getTotalCostInCents() {
        return totalCostInCents;
    }

    public List<Trip> getTrips() {
        return trips;
    }
}
