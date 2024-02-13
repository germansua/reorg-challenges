/*
 * This Java source file was generated by the Gradle 'init' task.
 */
    package com.reorg.challenge.weather.data.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import static com.reorg.challenge.weather.data.generator.data.WeatherData.nextWeatherData;

public class Main {

    private static final int DEFAULT_NUMBER_OF_RECORDS = 1000;

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("A number of records from 1 to 99999 must be provided");
            System.exit(-1);
        }

        if (!args[0].matches("\\d{1,5}")) {
            System.err.println("The value provided is not a number or exceed the limits (1 - 99999)");
            System.exit(-1);
        }

        var numberOfRecords = Integer.parseInt(args[0]);
        if (numberOfRecords < 1 || numberOfRecords > 999999) {
            numberOfRecords = DEFAULT_NUMBER_OF_RECORDS;
        }

        var objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        var weatherDataArray = JsonNodeFactory.instance.arrayNode();

        Stream.iterate(0, i -> i + 1)
                .map(i -> nextWeatherData())
                .limit(numberOfRecords)
                .forEach(wd -> weatherDataArray.add(objectMapper.valueToTree(wd)));

        objectMapper.writeValue(new File("random-weather.json"), weatherDataArray);
    }
}