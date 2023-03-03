package com.company.train.convertor.dto;

import java.util.List;

public class CustomerSummariesDTO {
    List<CustomerSummaryDTO> customerSummaries;

    public List<CustomerSummaryDTO> getCustomerSummaries() {
        return customerSummaries;
    }

    public void setCustomerSummaries(List<CustomerSummaryDTO> customerSummaries) {
        this.customerSummaries = customerSummaries;
    }

    public static class CustomerSummaryDTO {
        private int customerId;
        private int totalCostInCents;

        private List<TripsDTO> trips;

        public int getCustomerId() {
            return customerId;
        }

        public List<TripsDTO> getTrips() {
            return trips;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public int getTotalCostInCents() {
            return totalCostInCents;
        }

        public void setTotalCostInCents(int totalCostInCents) {
            this.totalCostInCents = totalCostInCents;
        }

        public void setTrips(List<TripsDTO> trips) {
            this.trips = trips;
        }

        public static class TripsDTO {
            private String stationStart;
            private String stationEnd;
            private long startedJourneyAt;
            private int costInCents;
            private int zoneFrom;
            private int zoneTo;

            public void setStationStart(String stationStart) {
                this.stationStart = stationStart;
            }

            public void setStationEnd(String stationEnd) {
                this.stationEnd = stationEnd;
            }

            public void setStartedJourneyAt(long startedJourneyAt) {
                this.startedJourneyAt = startedJourneyAt;
            }

            public void setCostInCents(int costInCents) {
                this.costInCents = costInCents;
            }

            public void setZoneFrom(int zoneFrom) {
                this.zoneFrom = zoneFrom;
            }

            public void setZoneTo(int zoneTo) {
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
    }

}
