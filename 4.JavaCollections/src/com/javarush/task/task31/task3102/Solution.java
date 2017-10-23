package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        ArrayList<String> fileList = new ArrayList();
        ArrayList<File> subList = new ArrayList();

        File folder = new File(root);
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) subList.add(file);
            else fileList.add(file.getAbsolutePath());
        }

        int count = 0;
        String curSubDir = "";
        while (count<subList.size()) {
            curSubDir = subList.get(count).getAbsolutePath();
            //System.out.println(curSubDir);
            try {
                folder = new File(curSubDir);
                for (File file : folder.listFiles()) {
                    if (file.isDirectory()) subList.add(file);
                    else fileList.add(file.getAbsolutePath());
                }

            } catch (Exception e)
            {
                System.out.println("Can't read directory");
            }

            count++;
        }
        return fileList;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String> files = new ArrayList<String> (getFileTree("g:\\"));
        for (int i=0; i<files.size(); i++ ) System.out.println(files.get(i));
    }
}
