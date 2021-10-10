package com.example.cryptokrypto.other.lambda;

@FunctionalInterface
public interface CarOperations {

    boolean isWorthToBuy(Car car);

    default long getPrice(Car car, boolean isFromPoland) {
        return 0;
    }
}
