package com.reorg.challenge.weather.data.aggregator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reorg.challenge.weather.data.aggregator.data.WeatherData;
import com.reorg.challenge.weather.data.aggregator.data.WeatherDataAggregates;
import com.reorg.challenge.weather.data.aggregator.data.WeatherDataHighestLowestTemp;

import java.io.File;
import java.io.IOException;

class WeatherParserService {

    private WeatherDataAggregates wda = new WeatherDataAggregates();
    private WeatherDataHighestLowestTemp wdhlt = new WeatherDataHighestLowestTemp();

    private File jsonFile;

    public WeatherParserService(File jsonFile) {
        this.jsonFile = jsonFile;
    }

    public void parse() {
        var objectMapper = new ObjectMapper();
        var jsonFactory = objectMapper.getFactory();

        try (var parser = jsonFactory.createParser(jsonFile)) {
            while (parser.nextToken() != null) {
                if (parser.currentToken() == null) {
                    break;
                }

                if (parser.currentToken().isStructStart()) {
                    while (parser.nextToken() != null && !parser.currentToken().isStructEnd()) {
                        var newWeatherData = objectMapper.readValue(parser, WeatherData.class);
                        wda.addNewData(newWeatherData);
                        wdhlt.compare(newWeatherData);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public WeatherDataAggregates getWda() {
        return wda;
    }

    public WeatherDataHighestLowestTemp getWdhlt() {
        return wdhlt;
    }
}
