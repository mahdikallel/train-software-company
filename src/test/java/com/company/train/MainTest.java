package com.company.train;

import com.company.train.constant.Constant;
import com.company.train.reader.FileReader;
import com.company.train.reader.JsonFileReader;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

class MainTest {

    private final FileReader fileReader = new JsonFileReader();
    @Test
    public void should_validate_file_output() throws IOException, URISyntaxException {
        // given
        String[] args = new String[2];
        args[0] = "src/test/resources/input.txt";
        args[1] = "src/test/resources/output.json";
        String expectedOutputFile = "src/test/resources/expected-output.json";
        Constant.objectMapper.writeValue(new File(args[1]), ""); // init output file

        // when
        Main.main(args);

        // then
        JsonNode actual = Constant.objectMapper.readTree(fileReader.readFileContent(args[1]));
        JsonNode expected = Constant.objectMapper.readTree(fileReader.readFileContent(expectedOutputFile));

        Assertions.assertEquals(
                expected,
                actual
        );

    }
}
