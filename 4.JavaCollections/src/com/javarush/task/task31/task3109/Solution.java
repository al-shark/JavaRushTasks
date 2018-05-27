package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) throws IOException {

        Properties prop = new Properties();
        Path pFile = Paths.get(fileName);

        if (Files.exists(pFile)) {
            FileInputStream fileInputStream = new FileInputStream(new File(pFile.toFile().getAbsolutePath()));
            if (fileName.toLowerCase().endsWith("xml")) prop.loadFromXML(fileInputStream);
            else prop.load(fileInputStream);
        }

        return prop;
    }
}
