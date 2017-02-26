package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();
        reader.close();

        ArrayList<String> buf = new ArrayList<>();

        int id=Integer.parseInt(args[1]);
        String name=args[2];
        if (name.length()>30) name=name.substring(0,30);
        String price,count;
        price = args[3];
        if (price.length()>8) price=price.substring(0,8);
        count = args[4];
        if (count.length()>4) count=count.substring(0,4);
        int fId=0;

        String res=String.format("%-8s%-30s%-8s%-4s",Integer.toString(id),name,price,count);

        String someString="";
        reader = new BufferedReader(new FileReader(fName));

        while (reader.ready()) {
            someString = reader.readLine();
            if ("".equals(someString)) continue;
            try {
                fId=Integer.parseInt(someString.substring(0,8).trim());
            }
            catch (Exception e) {
            }

            if (id==fId) {
                switch (args[0]) {
                    case "-d": break;
                    case "-u": buf.add(res);
                }
            }
            else buf.add(someString);
        }
        reader.close();

         BufferedWriter writer = new BufferedWriter(new FileWriter(fName));

         for (String x :buf) {
                writer.write(x);
                writer.newLine();
            }

         writer.close();
        }
    }