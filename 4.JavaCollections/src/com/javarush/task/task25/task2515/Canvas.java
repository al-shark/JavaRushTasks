package com.javarush.task.task25.task2515;

public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public char[][] getMatrix() {
        return matrix;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height][width];
    }
}
