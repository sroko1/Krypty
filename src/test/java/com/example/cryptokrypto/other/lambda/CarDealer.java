package com.example.cryptokrypto.other.lambda;

public class CarDealer {

    public boolean shouldIBuyThisCar(Car car) {
        return car.brand.equals("VW") && car.production.getYear() >= 2016;
    }

    public boolean shouldIBuyThisCar(Car car, CarOperations carOperations) {
        return carOperations.isWorthToBuy(car);
    }
}
