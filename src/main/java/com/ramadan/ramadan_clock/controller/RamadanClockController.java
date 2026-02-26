package com.ramadan.ramadan_clock.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ramadan.ramadan_clock.service.RamadanClockService;
import lombok.extern.slf4j.Slf4j;

@Slf4j 
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class RamadanClockController {

    private final RamadanClockService ramadanClockService;

    public RamadanClockController(RamadanClockService ramadanClockService) {
        this.ramadanClockService = ramadanClockService;
    }

    @GetMapping("/api/today")
    public Map<String, String> getTodayTime(@RequestParam(defaultValue = "Toronto") String city,
                                            @RequestParam(defaultValue = "Canada") String country) {
        log.debug("Fetching Today's Timing for {}, {}", city, country);
        return ramadanClockService.fetchTodaysTiming(city, country);
    }

    @GetMapping("/api/today/date")
    public String getTodayDate(@RequestParam(defaultValue = "Toronto") String city,
                                            @RequestParam(defaultValue = "Canada") String country) {
        log.debug("Fetching Today's Date for {}, {}", city, country);
        return ramadanClockService.fetchTodayDate(city, country);
    }

    @GetMapping("/api/ramadan/day")
    public String getRamadanDay(@RequestParam(defaultValue = "Toronto") String city,
                                            @RequestParam(defaultValue = "Canada") String country) {
        log.debug("Fetching Ramadan's day for {}, {}", city, country);
        return ramadanClockService.fetchRamadanDay(city, country);
    }
}
