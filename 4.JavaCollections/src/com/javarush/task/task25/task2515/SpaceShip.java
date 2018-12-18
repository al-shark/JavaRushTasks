package com.javarush.task.task25.task2515;

public class SpaceShip extends BaseObject {
    private double dx = 0;

    public void fire() {
        Rocket r1 = new Rocket(x-2,y);
        Rocket r2 = new Rocket(x+2,y);
        Space.game.getRockets().add(r1);
        Space.game.getRockets().add(r2);
    }

    public void move() {
        x = x + dx;
        checkBorders(0,Space.game.getWidth(),0,Space.game.getHeight());
    }

    public void draw(Canvas canvas) {}

    public void moveLeft() { dx = -1; }

    public void moveRight() {dx = 1; }

    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }
}
