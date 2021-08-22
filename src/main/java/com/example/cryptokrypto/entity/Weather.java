package com.example.cryptokrypto.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Weather {

    @Id
    @GeneratedValue
    private Long id;

    private String city;

    private Long temperatureInCelsius;
}
