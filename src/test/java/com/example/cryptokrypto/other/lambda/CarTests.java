package com.example.cryptokrypto.other.lambda;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class CarTests {
    private List<Car> cars;

    private void initCars() {
        cars = List.of(
                Car.builder()
                        .brand("Mazda")
                        .model("VI")
                        .color("red")
                        .production(LocalDate.of(2010, 1, 15))
                        .build(),
                Car.builder()
                        .brand("VW")
                        .model("Passat")
                        .color("blue")
                        .production(LocalDate.of(2021, 1, 1))
                        .build()
        );
    }

    @Test
    public void filterCars() {
        CarDealer decisionMaker = new CarDealer();
        cars.stream()
                .filter(decisionMaker::shouldIBuyThisCar);
    }
}
