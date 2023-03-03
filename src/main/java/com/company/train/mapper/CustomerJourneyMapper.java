package com.company.train.mapper;

import com.company.train.convertor.dto.CustomerJourneyDTO;
import com.company.train.domain.CustomerJourney;
import com.company.train.domain.Tap;

public class CustomerJourneyMapper {
    public static final CustomerJourneyMapper INSTANCE = new CustomerJourneyMapper();

    public CustomerJourney map(CustomerJourneyDTO customerJourneyDTO) {
        return new CustomerJourney(
                customerJourneyDTO.getTaps()
                        .stream()
                        .map(tapDTO -> new Tap(tapDTO.getUnixTimestamp(), tapDTO.getCustomerId(), tapDTO.getStation()))
                        .toList()
        );
    }
}
