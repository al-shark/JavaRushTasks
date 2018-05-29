package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0],"rw");
        long pos = Long.parseLong(args[1]);
        byte[] textB = args[2].getBytes();
        byte[] readB = new byte[textB.length];

        raf.seek(pos);
        int count = raf.read(readB,0,textB.length);
        raf.seek(raf.length());

        if (args[2].equals(new String(readB))) raf.write("true".getBytes());
        else raf.write("false".getBytes());

        raf.close();
    }
}
