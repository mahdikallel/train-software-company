package com.company.train.convertor.dto;

import java.util.List;

public class CustomerSummariesDTO {
    List<CustomerSummaryDTO> customerSummaries;

    public List<CustomerSummaryDTO> getCustomerSummaries() {
        return customerSummaries;
    }

    public static class CustomerSummaryDTO {
        private int customerId;
        private double totalCostInCents;

        private List<TripsDTO> trips;

        public int getCustomerId() {
            return customerId;
        }

        public double getTotalCostInCents() {
            return totalCostInCents;
        }

        public List<TripsDTO> getTrips() {
            return trips;
        }

        public static class TripsDTO {
            private String stationStart;
            private String stationEnd;
            private long startedJourneyAt;
            private double costInCents;
            private int zoneFrom;
            private int zoneTo;

            public String getStationStart() {
                return stationStart;
            }

            public String getStationEnd() {
                return stationEnd;
            }

            public long getStartedJourneyAt() {
                return startedJourneyAt;
            }

            public double getCostInCents() {
                return costInCents;
            }

            public int getZoneFrom() {
                return zoneFrom;
            }

            public int getZoneTo() {
                return zoneTo;
            }
        }
    }

}
