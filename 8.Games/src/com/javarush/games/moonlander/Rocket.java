package com.javarush.games.moonlander;

public class Rocket extends GameObject {
    private double speedY = 0;
    private double speedX = 0;
    private double boost = 0.05;

    public void move(boolean isUpPressed, boolean isLeftPressed, boolean isRightPressed) {
        if (isUpPressed) speedY = speedY - boost;
        else speedY = speedY + boost;
        y = y + speedY;

        boolean isXchanged = false;
        if (isLeftPressed) {speedX = speedX - boost; isXchanged = true;}
        if (isRightPressed) {speedX = speedX + boost; isXchanged = true;}
        if (isXchanged) x = x + speedX;
    }

    public Rocket(double x, double y) {
        super(x, y, ShapeMatrix.ROCKET);
    }
}
