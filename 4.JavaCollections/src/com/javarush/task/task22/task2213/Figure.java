package com.javarush.task.task22.task2213;

public class Figure {
    private int x;
    private int y;
    private int[][] matrix;

    public void left() {}

    public void right() {}

    public void up() {}

    public void down() {}

    public void rotate() {}

    public void downMaximum() {}

    public boolean isCurrentPositionAvailable() {return true;}

    public void landed() {}
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }
}
