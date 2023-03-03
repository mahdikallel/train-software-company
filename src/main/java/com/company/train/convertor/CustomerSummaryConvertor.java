package com.company.train.convertor;

import com.company.train.constant.Constant;
import com.company.train.convertor.dto.CustomerSummariesDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

public class CustomerSummaryConvertor {
    public CustomerSummariesDTO convert(String jsonFileContent) throws JsonProcessingException {
        return Constant.objectMapper.readValue(jsonFileContent, new TypeReference<>() {
        });
    }
}
