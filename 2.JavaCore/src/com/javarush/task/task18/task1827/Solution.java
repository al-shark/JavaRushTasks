package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = reader.readLine();
        reader.close();

        ArrayList<String> buf = new ArrayList<>();

        if ("-c".equals(args[0])) {
            int maxId = Integer.MIN_VALUE;
            reader = new BufferedReader(new FileReader(fName));
            int id=1;
            String someString="";
            while (reader.ready()) {
                someString=reader.readLine();
                if ("".equals(someString)) continue;
                buf.add(someString);
                try {
                    id=Integer.parseInt(someString.substring(0,8).trim());
                }
                catch (Exception e) {

                }
                if (id>maxId) maxId=id;
            }
            reader.close();
            maxId++;
            String res="";
            String name=args[1];
            if (name.length()>30) name=name.substring(0,30);
            String price,count;
            price = args[2];
            if (price.length()>8) price=price.substring(0,8);
            count = args[3];
            if (count.length()>4) count=count.substring(0,4);

            BufferedWriter writer = new BufferedWriter(new FileWriter(fName));
            res=String.format("%-8s%-30s%-8s%-4s",Integer.toString(maxId),name,price,count);
            buf.add(res);

            for (String x :buf) {
                writer.write(x);
                writer.newLine();
            }

            writer.close();
        }
    }

}
