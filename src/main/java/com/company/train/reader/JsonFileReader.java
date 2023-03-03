package com.company.train.reader;

import com.company.train.exception.TrainCompanyException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileReader implements FileReader {
    @Override
    public String readFileContent(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            String errorMessage = String.format("Error when reading file on path : %s", filePath);
            throw new TrainCompanyException(errorMessage,e);
        }
    }
}
