package com.javarush.task.task31.task3106;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileOutputStream fResFile = new FileOutputStream(args[0]);
        String[] fNames = Arrays.stream(args).skip(1).sorted().toArray(String[]::new);
        FileInputStream[] fStreams =new FileInputStream[fNames.length];
        for (int i=0; i<fNames.length; i++) fStreams[i] = new FileInputStream(fNames[i]);

        ZipInputStream zInputFile = new ZipInputStream(new SequenceInputStream(Collections.enumeration(Arrays.asList(fStreams))));

        for (ZipEntry entry = null; (entry = zInputFile.getNextEntry()) != null;) {
            byte[] buffer = new byte[1024];

            for (int readBytes = -1; (readBytes = zInputFile.read(buffer,0,1024)) > -1;) {
                fResFile.write(buffer,0,readBytes);
            }
        }
        zInputFile.close();
        fResFile.close();
    }
}
