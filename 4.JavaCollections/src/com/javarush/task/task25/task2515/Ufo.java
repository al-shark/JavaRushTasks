package com.javarush.task.task25.task2515;

import java.util.Random;

public class Ufo extends BaseObject {
    private static int[][] matrix = {
            {1, 1, 1, 1, 1},
            {0, 1, 1, 0, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 1, 0, 1},
            {1, 1, 1, 1, 1},
    };

    public void move() {
        double dx = Math.random() * 2 - 1; //-1..1
        double dy = Math.random() * 2 - 1; //-1..1

        x = x + dx;
        y = y + dy;

        checkBorders(radius, Space.game.getWidth() - radius + 1, 1, Space.game.getHeight()/2 + 1);

        if (new Random().nextInt(10) == 1) fire();
    }

    public void fire() {
        Space.game.getBombs().add(new Bomb(x, y+3));
    }

    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'U');
    }

    public Ufo(double x, double y) {
        super(x, y, 3);
    }
}
