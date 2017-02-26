package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count=0, tmp=-1, indCol=a[0].length;
        boolean isFound=false;

        while (tmp!=count) {
            tmp=count;

            extloop:
            for (int i=0; i<a.length; i++)
                for (int j=0; j<a[0].length; j++) {
                    if (a[i][j]==1 && !isFound) {
                        count++;
                        indCol=j;
                        isFound=true;
                        a[i][j]=0;
                    }
                    else if (a[i][j]==1 && isFound) {
                        a[i][j]=0;
                    }
                    else if (a[i][j]==0 && isFound && j>indCol) break;
                    else if (a[i][j]==0 && isFound && j==indCol) break extloop;
                }
            isFound=false;
        }
        return count;
    }
}
