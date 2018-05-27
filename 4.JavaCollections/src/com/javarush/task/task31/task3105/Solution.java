package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path fPath = Paths.get(args[0]);
        String sFileName = "new/"+fPath.getFileName().toString();
        String sZipFile = args[1];

        Map<String,ByteArrayOutputStream> mStorage = new HashMap<>();

        ByteArrayOutputStream bFile;

        byte[] tBBuffer = new byte[1024];

        int iReadLen = 0;

        ZipInputStream zFile = new ZipInputStream(new FileInputStream(sZipFile));
        ZipEntry zipEntry = zFile.getNextEntry();
        while (zFile.available() == 1) {
            bFile = new ByteArrayOutputStream();
            iReadLen = 0;
            while ((iReadLen = zFile.read(tBBuffer)) != -1) {
                bFile.write(tBBuffer,0,iReadLen);
            }
            bFile.close();
            mStorage.put(zipEntry.getName().toString(),bFile);
            zipEntry = zFile.getNextEntry();
        }
        zFile.close();

        ZipOutputStream zOutFile = new ZipOutputStream(new FileOutputStream(sZipFile));

        zOutFile.putNextEntry(new ZipEntry(sFileName));
        Files.copy(fPath,zOutFile);

        for (Map.Entry<String,ByteArrayOutputStream> entry : mStorage.entrySet()) {
           if (!entry.getKey().endsWith(fPath.getFileName().toString())) {
               zOutFile.putNextEntry(new ZipEntry(entry.getKey()));
               zOutFile.write(entry.getValue().toByteArray());
           }
        }
        zOutFile.close();

    }
}
