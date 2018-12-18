package com.javarush.task.task25.task2515;

public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        int xx = (int) Math.round(x);
        int yy = (int) Math.round(y);
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (!(matrix[j][i]==0)) setPoint(xx+i,yy+j,c);
            }
        }
    }

    public void setPoint(double x, double y, char c) {
        int xx = (int) Math.round(x);
        int yy = (int) Math.round(y);

        if (!((xx<0) || (yy<0) || (xx>=width) || (yy>=height))) matrix[yy][xx] = c;
    }

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
