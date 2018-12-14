package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

public class GameObject {
    public double x;
    public double y;
    public int[][] matrix;
    public int width;
    public int height;

    public void draw(Game gm) {
        if (!(matrix==null)) {
            for (int i = 0; i < width ; i++) {
                for (int j = 0; j < height ; j++) {
                    gm.setCellColor((int) (x+i),(int) (y+j),Color.values()[matrix[j][i]]);
                }
            }
        }
    }

    public GameObject(double x, double y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
        this.width = matrix[0].length;
        this.height = matrix.length;
    }
}
