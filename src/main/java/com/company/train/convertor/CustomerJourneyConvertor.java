package com.company.train.convertor;

import com.company.train.constant.Constant;
import com.company.train.convertor.dto.CustomerJourneyDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

public class CustomerJourneyConvertor {
    public CustomerJourneyDTO convert(String jsonFileContent) throws JsonProcessingException {
        return Constant.objectMapper.readValue(jsonFileContent, new TypeReference<CustomerJourneyDTO>() {
        });
    }
}
