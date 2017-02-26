package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fIn = reader.readLine();
        String fOut = reader.readLine();
        reader.close();

        BufferedReader file1 = new BufferedReader(new FileReader(fIn));
        String str = "";
        int num = 0;

        while (file1.ready()) str=str+" "+file1.readLine();
        file1.close();

        String[] nums = str.split(" ");

        BufferedWriter file2 = new BufferedWriter(new FileWriter(fOut));
        str="";
        for (String x: nums) {
            try {
                num=Integer.parseInt(x.trim());
                str = str + x.trim()+" ";
            }
            catch (NumberFormatException e)
            {

            }
        }
        file2.write(str);
        file2.close();
    }
}
