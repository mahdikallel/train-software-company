package com.company.train;

import com.company.train.constant.Constant;
import com.company.train.convertor.CustomerJourneyConvertor;
import com.company.train.convertor.dto.CustomerJourneyDTO;
import com.company.train.convertor.dto.CustomerSummariesDTO;
import com.company.train.domain.CustomerJourney;
import com.company.train.domain.CustomerSummary;
import com.company.train.mapper.CustomerJourneyMapper;
import com.company.train.mapper.CustomerSummaryMapper;
import com.company.train.reader.FileReader;
import com.company.train.reader.JsonFileReader;
import com.company.train.service.CustomerSummaryService;
import com.company.train.service.price.TripPricingService;
import com.company.train.service.trip.TripCreatorService;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final TripPricingService tripPricingService = new TripPricingService();
    private static final TripCreatorService tripCreatorService = new TripCreatorService(tripPricingService);
    private static final CustomerSummaryService customerSummaryService = new CustomerSummaryService(tripCreatorService);

    private static final CustomerJourneyConvertor customerJourneyConvertor = new CustomerJourneyConvertor();
    private static final FileReader fileReader = new JsonFileReader();

    public static void main(String[] args) throws IOException, URISyntaxException {
        if (args.length == 2) {
            String inputFilePath = args[0];
            String outputFilePath = args[1];
            logger.log(Level.INFO, "Input file path {0}", inputFilePath);
            logger.log(Level.INFO, "Output file path {0}", outputFilePath);


            CustomerJourneyDTO customerJourneyDTO = customerJourneyConvertor.convert(fileReader.readFileContent(inputFilePath));
            CustomerJourney customerJourney = CustomerJourneyMapper.INSTANCE.map(customerJourneyDTO);

            List<CustomerSummary> customerSummaries = customerSummaryService.groupTapsByCustomerId(customerJourney);

            CustomerSummariesDTO customerSummariesDTOS = CustomerSummaryMapper.INSTANCE.map(customerSummaries);
            Constant.objectMapper.writeValue(new File(outputFilePath), customerSummariesDTOS);

        } else {
            throw new IllegalArgumentException("This program take 2 arguments! Please provide two json files (intput and output)");
        }
    }
}
