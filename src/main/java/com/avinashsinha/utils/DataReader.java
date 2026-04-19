package com.avinashsinha.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    public List<HashMap<String, String>> getTestDataFromJson() throws IOException {

        // Convert JSON to String
        String jsonContent = null;
        try {

            jsonContent = FileUtils.readFileToString(
                    new File(System.getProperty("user.dir") + "/src/main/resources/TestData.json"),
                    StandardCharsets.UTF_8
            );

        } catch (IOException e) {

            System.out.println("Either File Not Found! or JSON Not Created!");
            throw new RuntimeException(e);

        }

        // Convert String to HashMap by Jackson DataBind Dependency
        ObjectMapper objectMapper = new ObjectMapper();
        List<HashMap<String, String>> data = objectMapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {

        });

        return data;

    }

}