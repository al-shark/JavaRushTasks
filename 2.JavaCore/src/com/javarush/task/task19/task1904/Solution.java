package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String str = fileScanner.nextLine();
            String[] data = str.split(" ");
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date dt;
            try {
                dt=format.parse(data[3]+"/"+data[4]+"/"+data[5]);
            }
            catch (ParseException e)
            {
                dt=new Date();
            }

            return new Person(data[1],data[2],data[0],dt);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
