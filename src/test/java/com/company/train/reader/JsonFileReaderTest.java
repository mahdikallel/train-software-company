package com.company.train.reader;


import com.company.train.exception.TrainCompanyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

class JsonFileReaderTest {


    FileReader jsonFileReader = new JsonFileReader();

    @Test
    void should_read_input_file_and_return_it_content() throws IOException, URISyntaxException {
        //given

        // when

        String fileContent = jsonFileReader.readFileContent("src/test/resources/input.txt");
        // then
        Assertions.assertFalse(fileContent.isEmpty());
    }

    @Test
    void should_throw_exception_when_file_not_found() {
        // given
        String filePath = "src/test/resources/not_found_file.txt";
        // when
        // then
        Assertions.assertThrows(TrainCompanyException.class, () -> {
            jsonFileReader.readFileContent(filePath);
        }, "Error when reading file on path :" + filePath);
    }


}
