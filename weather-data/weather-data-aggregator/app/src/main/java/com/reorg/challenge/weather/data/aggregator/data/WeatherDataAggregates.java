package com.reorg.challenge.weather.data.aggregator.data;

public class WeatherDataAggregates {

    private long aggregateTemperature;
    private long aggregateHumidity;
    private long counter;

    public void addNewData(WeatherData newWeatherData) {
        aggregateTemperature += newWeatherData.temperature();
        aggregateHumidity += newWeatherData.humidity();
        counter++;
    }

    public double calculateAverageTemperature() {
        return (double) aggregateTemperature / counter;
    }

    public double calculateAverageHumidity() {
        return (double) aggregateHumidity / counter;
    }
}
