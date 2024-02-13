package com.reorg.challenge.weather.data.generator.data;

import java.util.Random;

public enum WeatherConditions {
    SUNNY,
    PARTLY_CLOUDY,
    CLOUDY,
    RAINY,
    SNOWY;

    private static final Random random = new Random();

    @Override
    public String toString() {
        return this.name().substring(0, 1).toUpperCase() +
                this.name().substring(1).replace('_', ' ').toLowerCase();
    }

    public static String nextWeatherCondition() {
        return values()[random.nextInt(values().length)].toString();
    }
}
