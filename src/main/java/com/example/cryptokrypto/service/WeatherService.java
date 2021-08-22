package com.example.cryptokrypto.service;

import com.example.cryptokrypto.repository.WeatherRepository;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private WeatherRepository weatherRepository;

    public WeatherService(final WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }
}
