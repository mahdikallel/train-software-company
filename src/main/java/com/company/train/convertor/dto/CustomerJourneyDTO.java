package com.company.train.convertor.dto;

import java.util.List;

public class CustomerJourneyDTO {
    List<TapDTO> taps;

    public List<TapDTO> getTaps() {
        return taps;
    }

    public void setTaps(List<TapDTO> taps) {
        this.taps = taps;
    }

    public static class TapDTO {
        private long unixTimestamp;
        private int customerId;
        private String station;


        public long getUnixTimestamp() {
            return unixTimestamp;
        }

        public int getCustomerId() {
            return customerId;
        }

        public String getStation() {
            return station;
        }


        public void setUnixTimestamp(long unixTimestamp) {
            this.unixTimestamp = unixTimestamp;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public void setStation(String station) {
            this.station = station;
        }
    }

}
