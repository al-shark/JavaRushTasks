package com.javarush.task.task24.task2413;

/**
 * Created by sharka on 08.03.2017.
 */
public class Stand extends BaseObject {
    private double speed;
    private double direction;

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }

    public void moveLeft() {
        direction = -1;
    }

    public void moveRight() {
        direction = 1;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void move() {
        x = x + direction*speed;
    }
}
