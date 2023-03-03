package com.company.train.reader;

import java.net.URISyntaxException;

public interface FileReader {

    String readFileContent(String filePath) throws  URISyntaxException;
}
