package com.company.train.service;

import com.company.train.domain.CustomerJourney;
import com.company.train.domain.CustomerSummary;
import com.company.train.domain.Tap;
import com.company.train.domain.Trip;
import com.company.train.service.trip.TripCreatorService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerSummaryService {
    private final TripCreatorService tripCreatorService;

    public CustomerSummaryService(TripCreatorService tripCreatorService) {
        this.tripCreatorService = tripCreatorService;
    }


    public List<CustomerSummary> groupTapsByCustomerId(CustomerJourney customerJourney) {
        return customerJourney.getTaps()
                .stream()
                .sorted(Comparator.comparing(Tap::getUnixTimestamp))
                .collect(Collectors.groupingBy(Tap::getCustomerId))
                .entrySet()
                .stream()
                .map(this::buildCustomerSummary)
                .toList();
    }

    private CustomerSummary buildCustomerSummary(Map.Entry<Integer, List<Tap>> entry) {
        List<Trip> trips = tripCreatorService.create(entry.getValue());
        int totalCostInCents = trips.stream().map(Trip::getCostInCents).reduce(0, Integer::sum);
        return new CustomerSummary(entry.getKey(), totalCostInCents, trips);
    }
}
