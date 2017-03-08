package com.javarush.task.task24.task2413;

import java.util.List;

/**
 * Created by sharka on 08.03.2017.
 */
public class Arkanoid {
    private int width, height;
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    static Arkanoid game;
    private boolean isGameOver;

    public void run() {}

    public void move() {
        ball.move();
        stand.move();
    }

    public void checkBricksBump() {
        double angle = Math.random() * 360;
        for (int i=0; i<bricks.size(); i++) {
            if (ball.isIntersec(bricks.get(i))) {
                ball.setDirection(angle);
                bricks.remove(i);
                break;
            }
        }
    }

    public void checkEndGame() {
        if (ball.getY()>height) isGameOver=true;
    }

    public void checkStandBump() {
        double angle = 90 + 20 * (Math.random() - 0.5);

        if (ball.isIntersec(stand)) ball.setDirection(angle);
    }

    public void draw(Canvas canvas) {
        ball.draw(canvas);
        stand.draw(canvas);
        for (Brick x : bricks) x.draw(canvas);
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static void main (String[] args) {

    }
}
