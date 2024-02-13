package com.reorg.challenge.weather.data.aggregator.service;

import java.io.File;

public class WeatherStatisticsService {

    public static void printStatistics(File jsonFile) {
        var weatherParserService = new WeatherParserService(jsonFile);
        weatherParserService.parse();

        var wda = weatherParserService.getWda();
        var wdhlt = weatherParserService.getWdhlt();

        System.out.println("*** Weather Statistics ***");
        System.out.printf("Average Temperature for all cities: %.2f%n", wda.calculateAverageTemperature());
        System.out.printf("Average Humidity for all cities: %.2f%n", wda.calculateAverageHumidity());
        System.out.println("City with the Highest Temperature: " + wdhlt.getHighestTemp());
        System.out.println("City with the Lowest Temperature: " + wdhlt.getLowestTemp());
    }
}
