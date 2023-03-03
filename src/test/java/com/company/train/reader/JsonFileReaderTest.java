package com.company.train.reader;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

class JsonFileReaderTest {


    FileReader jsonFileReader = new JsonFileReader();

    @Test
    public void should_read_input_file_and_return_it_content() throws IOException, URISyntaxException {
        //given

        // when

        String fileContent = jsonFileReader.readFileContent("src/test/resources/input.txt");
        // then
        Assertions.assertFalse(fileContent.isEmpty());
    }


}
