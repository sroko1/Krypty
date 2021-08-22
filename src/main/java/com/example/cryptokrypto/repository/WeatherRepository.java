package com.example.cryptokrypto.repository;

import com.example.cryptokrypto.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
