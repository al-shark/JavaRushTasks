package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {
    public static int numFolders = 0;
    public static int numFiles = 0;
    public static long sizeFiles = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Уведіть шлях до папки:");
        String readPath = reader.readLine();
        reader.close();
        Path filePath = Paths.get(readPath);
        if (Files.isDirectory(filePath)) {

            Files.walkFileTree(filePath, new PathVizit());
            numFolders--;

            System.out.println("Всего папок - " + numFolders);
            System.out.println("Всего файлов - " + numFiles);
            System.out.println("Общий размер - " + sizeFiles);
        } else {
            System.out.println(readPath + " - не папка");
        }
    }

    private static class PathVizit extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            numFolders++;
            return super.preVisitDirectory(dir, attrs);
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            numFiles++;
            sizeFiles += attrs.size();
            return super.visitFile(file, attrs);
        }

    }
}
