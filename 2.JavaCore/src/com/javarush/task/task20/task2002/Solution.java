package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User tUser=new User();
            /*tUser.setBirthDate(new Date());
            tUser.setCountry(User.Country.UKRAINE);
            tUser.setFirstName("Иван");
            tUser.setLastName("Иванов");
            tUser.setMale(true); */
            javaRush.users.add(tUser);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            System.out.println(javaRush.equals(loadedObject));
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println("JRStart");
            writer.println(users.size()>0 ? "yes" : "no");
            if (users.size()>0) {
                writer.println(users.size());

                for (User x : users) {
                    writer.println(x.getFirstName());
                    writer.println(x.getLastName());
                    writer.println(x.getBirthDate()!=null ? x.getBirthDate().getTime() : "null");
                    writer.println(x.isMale());
                    writer.println(x.getCountry());
                }
            }
            writer.flush();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            users = new ArrayList<>();
            User tUser;

            while (reader.ready()) {
                if ("JRStart".equals(reader.readLine())) {
                    if ("yes".equals(reader.readLine())) {
                        int count = Integer.parseInt(reader.readLine());
                        String tStr="";
                        for (int i=0; i<count; i++) {
                            tUser=new User();
                            tStr=reader.readLine();
                            tUser.setFirstName(!"null".equals(tStr) ? tStr : null);
                            tStr=reader.readLine();
                            tUser.setLastName(!"null".equals(tStr) ? tStr : null);
                            tStr=reader.readLine();
                            tUser.setBirthDate(!"null".equals(tStr) ? new Date(Long.parseLong(tStr)) : null);
                            tUser.setMale(Boolean.parseBoolean(reader.readLine()));
                            tStr=reader.readLine();
                            tUser.setCountry(!"null".equals(tStr) ? User.Country.valueOf(tStr) : null);
                            users.add(tUser);
                        }
                    }
                    break;
                }
            }
            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
