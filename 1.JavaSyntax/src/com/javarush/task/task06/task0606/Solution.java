package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        for (int i=0;i<s.length();i++)
            if ((Integer.parseInt(s.substring(i,i+1)) % 2)==0) even++;
            else odd++;
        System.out.println("Even: "+even+" Odd: "+odd);
        //напишите тут ваш код
    }
}
