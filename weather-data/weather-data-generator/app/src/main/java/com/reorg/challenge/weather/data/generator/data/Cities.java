package com.reorg.challenge.weather.data.generator.data;

import java.util.List;
import java.util.Random;

public class Cities {
    private static final List<String> cities = List.of("New York", "Los Angeles", "Chicago", "Houston", "Phoenix",
            "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose", "Austin", "Jacksonville", "San Francisco",
            "Columbus", "Indianapolis", "Fort Worth", "Charlotte", "Seattle", "Denver", "El Paso", "Detroit", "Washington",
            "Boston", "Memphis", "Nashville", "Portland", "Oklahoma City", "Las Vegas", "Baltimore", "Louisville", "Milwaukee",
            "Albuquerque", "Tucson", "Fresno", "Sacramento", "Mesa", "Atlanta", "Kansas City", "Colorado Springs", "Miami",
            "Raleigh", "Omaha", "Long Beach", "Virginia Beach", "Oakland", "Minneapolis", "Tulsa", "Arlington", "Tampa");

    private static final Random random = new Random();

    public static String nextCity() {
        return cities.get(random.nextInt(cities.size()));
    }
}
