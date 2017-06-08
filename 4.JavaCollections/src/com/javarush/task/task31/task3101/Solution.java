package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/*
Проход по дереву файлов
*/
public class Solution {
    public static ArrayList<File> fList = new ArrayList<File>();

    public static void main(String[] args) throws Exception {
        String fPath = args[0];
        String sFileOut = args[1];

        File fOut = new File(sFileOut);
        File fNewOut = new File(fOut.getParent()+"\\allFilesContent.txt");
        FileUtils.renameFile(fOut,fNewOut);

        try (FileOutputStream fOutStream = new FileOutputStream(fNewOut)) {
            enumerateFolder(fPath);
            FileInputStream fIn = null;
            Collections.sort(fList);
            for (File x : fList) {
                fIn = new FileInputStream(x);
                while (fIn.available() > 0) {
                    fOutStream.write(fIn.read());
                }
                fOutStream.write(System.lineSeparator().getBytes());
                fIn.close();

            }
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    public static void enumerateFolder(String folderPath) {
        File folder = new File(folderPath);
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) enumerateFolder(file.getAbsolutePath());
            else {
                if (file.length() > 50) FileUtils.deleteFile(file);
                else fList.add(file);
                }
        }
    }
}