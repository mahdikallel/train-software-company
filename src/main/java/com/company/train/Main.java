package com.company.train;

import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        if (args.length == 2) {
            String inputFilePath = args[0];
            String outputFilePath = args[1];
            logger.info("Input file path" + inputFilePath);
            logger.info("Output file path" + outputFilePath);
        } else {
            throw new IllegalArgumentException("This program take 2 arguments! Please provide two json files (intput and output)");
        }
    }
}
