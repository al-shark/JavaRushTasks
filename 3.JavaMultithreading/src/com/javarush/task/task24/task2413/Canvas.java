package com.javarush.task.task24.task2413;

/**
 * Created by sharka on 08.03.2017.
 */
public class Canvas {
    private int width, height;
    private char[][] matrix;

    public void clear() {
        matrix = new char[height+2][width+2];
    }

    public void print() {
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++) System.out.print(matrix[i][j]);
            System.out.println();
        }
    }

    public void setPoint(double x, double y, char c) {
        int xx=(int) Math.round(x);
        int yy=(int) Math.round(y);
        if (yy>=0 && yy<=matrix.length)
            if (xx>=0 && xx<=matrix[0].length) matrix[yy][xx]=c;
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i=0; i<matrix.length; i++)
            for (int j=0; j<matrix[0].length; j++)
                if (matrix[i][j]!=0) setPoint(x+j,y+i,c);
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

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height+2][width+2];
    }
}
