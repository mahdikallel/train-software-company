package com.company.train.convertor.dto;

import java.util.List;

public class CustomerJourneyDTO {
    List<TapDTO> taps;

    public List<TapDTO> getTaps() {
        return taps;
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
    }

}
