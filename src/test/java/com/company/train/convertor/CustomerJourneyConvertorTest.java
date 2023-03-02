package com.company.train.convertor;

import com.company.train.convertor.dto.CustomerJourneyDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CustomerJourneyConvertorTest {
    CustomerJourneyConvertor customerJourneyConvertor = new CustomerJourneyConvertor();

    @Test
    public void should_read_string_and_convert_it_to_customer_journey_object() throws IOException {

        // given

        // when
        CustomerJourneyDTO customerJourneyDTO = customerJourneyConvertor.convert("""
                {
                  "taps" : [ {
                    "unixTimestamp" : 13,
                    "customerId" : 1,
                    "station" : "A"
                  }]
                }
                """);

        //then
        Assertions.assertNotNull(customerJourneyDTO);
        Assertions.assertEquals(1, customerJourneyDTO.getTaps().size());
        Assertions.assertEquals(13, customerJourneyDTO.getTaps().get(0).getUnixTimestamp());
        Assertions.assertEquals(1, customerJourneyDTO.getTaps().get(0).getCustomerId());
        Assertions.assertEquals("A", customerJourneyDTO.getTaps().get(0).getStation());
    }
}
