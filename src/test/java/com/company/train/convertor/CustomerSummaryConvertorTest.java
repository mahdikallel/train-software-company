package com.company.train.convertor;

import com.company.train.convertor.dto.CustomerSummariesDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CustomerSummaryConvertorTest {

    CustomerSummaryConvertor customerJourneyConvertor = new CustomerSummaryConvertor();

    @Test
    public void should_read_string_and_convert_it_to_customer_journey_object() throws IOException {

        // given

        // when
        CustomerSummariesDTO customerSummariesDTO = customerJourneyConvertor.convert("""
                {
                  "customerSummaries" : [ {
                    "customerId" : 1,
                    "totalCostInCents" : 240,
                    "trips" : [ {
                      "stationStart" : "A",
                      "stationEnd" : "D",
                      "startedJourneyAt" : 1,
                      "costInCents" : 240,
                      "zoneFrom" : 1,
                      "zoneTo" : 2
                    } ]
                  }]
                }""");

        //then
        Assertions.assertNotNull(customerSummariesDTO);
        Assertions.assertEquals(1, customerSummariesDTO.getCustomerSummaries().size());
        Assertions.assertEquals(1, customerSummariesDTO.getCustomerSummaries().get(0).getCustomerId());
        Assertions.assertEquals(240, customerSummariesDTO.getCustomerSummaries().get(0).getTotalCostInCents());

        Assertions.assertEquals(1, customerSummariesDTO.getCustomerSummaries().get(0).getTrips().size());
        Assertions.assertEquals("A", customerSummariesDTO.getCustomerSummaries().get(0).getTrips().get(0).getStationStart());
        Assertions.assertEquals("D", customerSummariesDTO.getCustomerSummaries().get(0).getTrips().get(0).getStationEnd());
        Assertions.assertEquals(1, customerSummariesDTO.getCustomerSummaries().get(0).getTrips().get(0).getStartedJourneyAt());
        Assertions.assertEquals(240, customerSummariesDTO.getCustomerSummaries().get(0).getTrips().get(0).getCostInCents());
        Assertions.assertEquals(1, customerSummariesDTO.getCustomerSummaries().get(0).getTrips().get(0).getZoneFrom());
        Assertions.assertEquals(2, customerSummariesDTO.getCustomerSummaries().get(0).getTrips().get(0).getZoneTo());

    }
}
