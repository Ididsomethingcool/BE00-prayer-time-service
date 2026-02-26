package com.ramadan.ramadan_clock.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RamadanClockService {
    
    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> fetchData(String city, String country) {
        String url = "https://api.aladhan.com/v1/timingsByCity"
                + "?city=" + city
                + "&country=" + country
                + "&method=2";

        Map<String, Object> response = restTemplate.getForObject(url, Map.class); // convert json to map
        return (Map<String, Object>) response.get("data"); // cause its under timings
    }
    public Map<String,String> fetchTodaysTiming(String city, String country) {
        Map<String, Object> data = fetchData(city, country);
        return (Map<String, String>) data.get("timings");
    }

    public String fetchTodayDate(String city, String country) {
        Map<String, Object> data = fetchData(city, country);
        Map<String, String> date = (Map<String, String>) data.get("date");
        return date.get("readable");
    }

    public String fetchRamadanDay(String city, String country) {
        Map<String, Object> data = fetchData(city, country);
        Map<String, String> date = (Map<String, String>) data.get("date");
        return date.get("day");
    }
}
