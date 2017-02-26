package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap <Integer,String> names = new TreeMap<>();

        String fname = reader.readLine();
        String outfname = "";
        while (!"end".equals(fname)) {
            names.put(Integer.parseInt(fname.substring(5+fname.lastIndexOf(".part"))),fname);
            outfname = fname.substring(0,fname.lastIndexOf(".part"));
            fname = reader.readLine();
        }
        reader.close();

        byte[] buff = new byte[100];
        int rd = 0;

        FileOutputStream fout = new FileOutputStream(outfname);
        FileInputStream fin;

        for (Map.Entry<Integer,String> x: names.entrySet()) {
            fin = new FileInputStream(x.getValue());

            while (fin.available()>0) {
                rd=fin.read(buff);
                fout.write(buff,0,rd);
            }

            fin.close();
        }

        fout.close();


    }
}
