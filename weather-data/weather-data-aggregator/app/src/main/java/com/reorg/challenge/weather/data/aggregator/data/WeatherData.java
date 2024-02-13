package com.reorg.challenge.weather.data.aggregator.data;

public record WeatherData(String city, int temperature, int humidity, String condition) {

    public boolean isHigherTempThan(WeatherData other) {
        return this.temperature > other.temperature;
    }

    public boolean isLowerTempThan(WeatherData other) {
        return this.temperature < other.temperature;
    }

    @Override
    public String toString() {
        return city + ", temperature=" + temperature;
    }
}
