package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader fIn = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fOut = new BufferedWriter(new FileWriter(args[1]));

        String str;
        String[] pstr;
        ArrayList<String> astr = new ArrayList<>();
        while (fIn.ready()) {
            pstr = fIn.readLine().split(" ");
            for (String x : pstr)
                if (x.length()>6) astr.add(x);
        }
        fIn.close();

        int last=astr.size();
        for (String x : astr) {
            fOut.write(x);
            last--;
            if (last>0) fOut.write(",");
        }
        fOut.close();
    }
}
