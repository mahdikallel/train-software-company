package com.company.train.reader;

import java.io.IOException;
import java.net.URISyntaxException;

public interface FileReader {

    String readFileContent(String filePath) throws IOException, URISyntaxException;
}
