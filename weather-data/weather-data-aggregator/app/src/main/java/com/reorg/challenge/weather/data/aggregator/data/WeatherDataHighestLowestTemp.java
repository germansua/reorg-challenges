package com.reorg.challenge.weather.data.aggregator.data;

public class WeatherDataHighestLowestTemp {

    private WeatherData highestTemp = new WeatherData("", 0, 0, "");
    private WeatherData lowestTemp = new WeatherData("", Integer.MAX_VALUE, 0, "");

    public void compare(WeatherData newWeatherData) {
        if (newWeatherData.isHigherTempThan(highestTemp)) {
            highestTemp = newWeatherData;
        }

        if (newWeatherData.isLowerTempThan(lowestTemp)) {
            lowestTemp = newWeatherData;
        }
    }

    public WeatherData getHighestTemp() {
        return highestTemp;
    }

    public WeatherData getLowestTemp() {
        return lowestTemp;
    }
}
