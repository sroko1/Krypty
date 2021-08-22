package com.example.cryptokrypto.mapper;

import com.example.cryptokrypto.dto.WeatherDto;
import com.example.cryptokrypto.entity.Weather;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper implements Mapper<Weather, WeatherDto> {

    @Override
    public WeatherDto fromEntityToDto(Weather weather) {
        return new WeatherDto(weather.getId(), weather.getCity(), weather.getTemperatureInCelsius());
    }

    @Override
    public Weather fromDtoToEntity(WeatherDto weatherDto) {
        return Weather.builder()
                .id(weatherDto.id())
                .city(weatherDto.myCity())
                .temperatureInCelsius(weatherDto.tempInCelsius())
                .build();
    }
}
