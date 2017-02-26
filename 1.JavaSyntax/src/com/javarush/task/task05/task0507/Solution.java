package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int count = 0;
        int sum = 0;
        int r = 0;
        while ((r=scan.nextInt())!=-1)
        {
            sum=sum+r;
            count++;
        }
        System.out.println((float) (sum*1.0/count));
        //напишите тут ваш код
    }
}

