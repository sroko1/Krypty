package com.example.cryptokrypto.controller;

import com.example.cryptokrypto.dto.WeatherDto;
import com.example.cryptokrypto.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class WeatherController {

    private WeatherService weatherService;

    public WeatherController(final WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weathers")
    public List<WeatherDto> getAll() {
        log.info("getAll");
        return weatherService.getAllWeathers();
    }

    // /weathers/1
    // /weathers/99
    @GetMapping("/weathers/{id}")
    public ResponseEntity<WeatherDto> getWeatherById(@PathVariable("id") Long id) {
        log.info("getWeatherById: [{}]", id);
        var result = weatherService.findWeatherById(id);

        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // /create-new-weather ??
    // /create-new-weather-and-city ??
    // /weathers -> POST
    @PostMapping("/weathers")
    public ResponseEntity<WeatherDto> createWeatherForecast(@RequestBody WeatherDto newWeather) {
        log.info("trying to create new weather forecast: [{}]", newWeather);
//        return new ResponseEntity<>(weatherService.createNewWeatherForecast(newWeather), HttpStatus.CREATED);
        var body = weatherService.createNewWeatherForecast(newWeather);

//        MultiValueMap<String, String> headers = new HttpHeaders();
//        headers.add(HttpHeaders.LOCATION, "/api/weathers/" + body.id());
//        new ResponseEntity<WeatherDto>(body, headers, HttpStatus.CREATED);

        return ResponseEntity.created(URI.create("/api/weathers/" + body.id())).body(body);
    }

    // /api/weathers/{id}
    // 204 -> OK - no content
    // 404 -> not found
    @DeleteMapping("/weathers/{id}")
    public ResponseEntity<Void> deleteWeatherForecastById(@PathVariable Long id) {
        log.info("trying to delete weather by id: [{}]", id);
        boolean deleted = weatherService.deleteWeatherById(id);
//        if (deleted) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // replace
    @PutMapping("/weathers/{id}")
    public WeatherDto replaceWeatherForecast(@PathVariable("id") Long id, @RequestBody WeatherDto objectToReplace) {
        return null;
    }

    // partial update
    @PatchMapping("/weathers/{id}")
    public WeatherDto updateWeatherForecast(@PathVariable("id") Long id, @RequestBody WeatherDto updateDto) {
        return null;
    }

}
