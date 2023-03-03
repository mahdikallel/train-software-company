package com.company.train.mapper;

import com.company.train.convertor.dto.CustomerSummariesDTO;
import com.company.train.domain.CustomerSummary;
import com.company.train.domain.Trip;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerSummaryMapper {
    public static final CustomerSummaryMapper INSTANCE = new CustomerSummaryMapper();

    public CustomerSummariesDTO map(List<CustomerSummary> customerSummaries) {

        CustomerSummariesDTO customerSummariesDTO = new CustomerSummariesDTO();
        List<CustomerSummariesDTO.CustomerSummaryDTO> collect = customerSummaries.stream()
                .map(customerSummary -> {
                    CustomerSummariesDTO.CustomerSummaryDTO customerSummaryDTO = new CustomerSummariesDTO.CustomerSummaryDTO();
                    customerSummaryDTO.setCustomerId(customerSummary.getCustomerId());
                    customerSummaryDTO.setTotalCostInCents(customerSummary.getTotalCostInCents());
                    customerSummaryDTO.setTrips(mapToTripDto(customerSummary.getTrips()));
                    return customerSummaryDTO;
                }).collect(Collectors.toList());

        customerSummariesDTO.setCustomerSummaries(
                collect
        );
        return customerSummariesDTO;
    }

    private List<CustomerSummariesDTO.CustomerSummaryDTO.TripsDTO> mapToTripDto(List<Trip> trips) {
        return trips.stream()
                .map(trip -> {
                    CustomerSummariesDTO.CustomerSummaryDTO.TripsDTO tripsDTO = new CustomerSummariesDTO.CustomerSummaryDTO.TripsDTO();
                    tripsDTO.setCostInCents(trip.getCostInCents());
                    tripsDTO.setStationEnd(trip.getStationEnd());
                    tripsDTO.setStationStart(trip.getStationStart());
                    tripsDTO.setZoneTo(trip.getZoneTo());
                    tripsDTO.setZoneFrom(trip.getZoneFrom());
                    tripsDTO.setStartedJourneyAt(trip.getStartedJourneyAt());
                    return tripsDTO;
                }).toList();
    }
}
