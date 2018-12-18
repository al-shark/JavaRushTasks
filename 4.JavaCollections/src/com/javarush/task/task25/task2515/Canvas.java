package com.javarush.task.task25.task2515;

public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public void print() {
        for (int i = 0; i < height ; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public void clear() {
        for (int i = 0; i < width ; i++) {
            for (int j = 0; j < height; j++) {
                matrix[j][i] = ' ';
            }
        }
    }
    
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
