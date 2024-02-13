package com.reorg.challenge.weather.data.generator.data;

import java.util.Random;

import static com.reorg.challenge.weather.data.generator.data.Cities.nextCity;

public record WeatherData(String city, int temperature, int humidity, String condition) {

    private static final Random random = new Random();

    public static WeatherData nextWeatherData() {
        return new WeatherData(
                nextCity(),
                random.nextInt(100),
                random.nextInt(100),
                WeatherConditions.nextWeatherCondition());
    }
}
