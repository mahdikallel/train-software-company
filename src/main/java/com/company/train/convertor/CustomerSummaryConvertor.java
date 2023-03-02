package com.company.train.convertor;

import com.company.train.convertor.dto.CustomerSummariesDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerSummaryConvertor {
    public CustomerSummariesDTO convert(String jsonFileContent) throws JsonProcessingException {
        return new ObjectMapper().readValue(jsonFileContent, new TypeReference<>() {
        });
    }
}
