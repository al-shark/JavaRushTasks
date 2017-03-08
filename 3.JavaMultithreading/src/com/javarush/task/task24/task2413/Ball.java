package com.javarush.task.task24.task2413;

/**
 * Created by sharka on 08.03.2017.
 */
public class Ball extends BaseObject {
    private double speed;
    private double direction;
    private double dx;
    private double dy;
    private boolean isFrozen;

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
        isFrozen = true;
    }

    public void setDirection(double direction) {
        this.direction = direction;
        double angle = Math.toRadians(direction);
        dx = Math.cos(angle) * speed;
        dy = -Math.sin(angle) * speed;
    }

    public void checkRebound(int minx, int maxx, int miny, int maxy) {}

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x,y,'O');
    }

    @Override
    public void move() {
        if (!isFrozen) {
            x+=dx;
            y+=dy;
        }
    }

    public void start() {
        isFrozen=false;
    }
}
