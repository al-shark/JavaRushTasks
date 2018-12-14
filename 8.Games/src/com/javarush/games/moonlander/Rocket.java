package com.javarush.games.moonlander;

public class Rocket extends GameObject {
    private double speedY = 0;
    private double speedX = 0;
    private double boost = 0.05;
    private double slowdown = boost/10;

    private void checkBorders(){
        if (x < 0) {
            x=0;
            speedX = 0;
        }
        if ((x+width) > MoonLanderGame.WIDTH) {
            x = MoonLanderGame.WIDTH - width;
            speedX = 0;
        }
        if (y < 0) {
            y = 0;
            speedY = 0;
        }
    }

    public void move(boolean isUpPressed, boolean isLeftPressed, boolean isRightPressed) {
        if (isUpPressed) speedY = speedY - boost;
        else speedY = speedY + boost;
        y = y + speedY;

        boolean isXchanged = false;
        if (isLeftPressed) {speedX = speedX - boost; isXchanged = true;}
        if (isRightPressed) {speedX = speedX + boost; isXchanged = true;}
        if (!isLeftPressed && !isRightPressed) {
            if ((((-1)*slowdown) <= speedX) && (speedX <= slowdown)) {speedX = 0; isXchanged =true;}
            else {
                if (speedX > slowdown) {speedX = speedX - slowdown; isXchanged = true;}
                else {
                    if (speedX < ((-1)*slowdown)) {speedX = speedX + slowdown; isXchanged = true;}
                }
            }
        }
        if (isXchanged) x = x + speedX;
        checkBorders();
    }

    public Rocket(double x, double y) {
        super(x, y, ShapeMatrix.ROCKET);
    }
}
