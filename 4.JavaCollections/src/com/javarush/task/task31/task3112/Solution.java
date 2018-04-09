package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("http://sprinter4wd.narod.ru/poleznye_melochi/timer/files/555.GIF", Paths.get("D:/1"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();

        String fName = urlString.substring(urlString.lastIndexOf("/")+1);
        Path tempFile = Files.createTempFile("tmp",".tmp");
        Files.copy(inputStream,tempFile);

        Path path = Files.move(tempFile, downloadDirectory.resolve(fName));

        return path;

        // implement this method
    }
}
