package com.javarush.task.task29.task2909.car;

/**
 * Created by sharka on 19.04.2017.
 */
public class Truck extends Car {
    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }

    public Truck(int numberOfPassengers) {
        super(0, numberOfPassengers);
    }
}
