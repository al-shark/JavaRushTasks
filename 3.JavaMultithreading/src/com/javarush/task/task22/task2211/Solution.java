package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        FileInputStream reader =  new FileInputStream(args[0]);
        FileOutputStream writer = new FileOutputStream(args[1]);

        Charset utf8 = Charset.forName("UTF-8");
        Charset win1251 = Charset.forName("Windows-1251");

        byte[] buffer = new byte[reader.available()];

        reader.read(buffer);
        String s= new String(buffer, utf8);
        buffer = s.getBytes(win1251);
        writer.write(buffer);

        reader.close();
        writer.close();
    }
}
