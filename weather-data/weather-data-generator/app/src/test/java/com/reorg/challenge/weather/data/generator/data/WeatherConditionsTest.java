package com.reorg.challenge.weather.data.generator.data;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherConditionsTest {

    @Test
    void capitalizeToStringTest() {
        var expected = List.of("Sunny", "Partly cloudy", "Cloudy", "Rainy", "Snowy");
        var actual = Arrays.stream(WeatherConditions.values()).map(WeatherConditions::toString).toList();
        assertEquals(expected, actual);
    }
}