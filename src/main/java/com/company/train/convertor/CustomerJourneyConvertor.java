package com.company.train.convertor;

import com.company.train.convertor.dto.CustomerJourneyDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerJourneyConvertor {
    public CustomerJourneyDTO convert(String jsonFileContent) throws JsonProcessingException {
        return new ObjectMapper().readValue(jsonFileContent, new TypeReference<CustomerJourneyDTO>() {
        });
    }
}
