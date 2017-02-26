package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public Properties p;

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sFile = reader.readLine();
        reader.close();

        InputStream inputStream = new FileInputStream(sFile);

        load(inputStream);

        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {

        p= new Properties();
        p.putAll(properties);
        p.store(outputStream,"");
        outputStream.flush();

        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {

        p = new Properties();
        p.load(inputStream);

        for (String x : p.stringPropertyNames()) properties.put(x,p.getProperty(x));
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {

    }
}
