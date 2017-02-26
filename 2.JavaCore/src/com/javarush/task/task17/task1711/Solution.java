package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat form = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person perc;

        switch (args[0])
        {
            case "-c":
                for (int i=0;i<args.length/3;i++)
                {
                    synchronized (allPeople) {
                        if ("м".equals(args[2 + i * 3]))
                            allPeople.add(Person.createMale(args[1 + i * 3], format.parse(args[3 + i * 3])));
                        else if ("ж".equals(args[2 + i * 3]))
                            allPeople.add(Person.createFemale(args[1 + i * 3], format.parse(args[3 + i * 3])));
                    }
                    System.out.println(allPeople.size() - 1);
                }
                break;
            case "-u":
                for (int i=0;i<args.length/4;i++)
                {
                    synchronized (allPeople) {
                        perc = allPeople.get(Integer.parseInt(args[1 + i * 4]));
                        perc.setName(args[2 + i * 4]);
                        if ("м".equals(args[3 + i * 4])) perc.setSex(Sex.MALE);
                        else if ("ж".equals(args[3 + i * 4])) perc.setSex(Sex.FEMALE);
                        perc.setBirthDay(format.parse(args[4 + i * 4]));
                    }
                }
                break;
            case "-d":
                for (int i=1;i<args.length;i++)
                {
                    synchronized (allPeople) {
                        perc = allPeople.get(Integer.parseInt(args[i]));
                        perc.setName(null);
                        perc.setSex(null);
                        perc.setBirthDay(null);
                    }
                }
                break;
            case "-i":
                for (int i=1;i<args.length;i++) {
                    synchronized (allPeople) {
                    perc = allPeople.get(Integer.parseInt(args[i]));
                    System.out.print(perc.getName() + " ");
                    if (Sex.MALE.equals(perc.getSex())) System.out.print("м ");
                    else if (Sex.FEMALE.equals(perc.getSex())) System.out.print("ж ");
                    System.out.println(form.format(perc.getBirthDay()));
                    }
                }
        }
//start here - начни тут
    }
}
