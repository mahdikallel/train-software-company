package com.company.train.domain;

import java.util.List;

public class CustomerJourney {
    private final List<Tap> taps;

    public CustomerJourney(List<Tap> taps) {
        this.taps = taps;
    }

    public List<Tap> getTaps() {
        return taps;
    }
}
