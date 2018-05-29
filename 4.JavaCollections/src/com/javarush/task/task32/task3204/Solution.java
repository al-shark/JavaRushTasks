package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        Random rnd = new Random();
        byte[] firstA = {48,49,50,51,52,53,54,55,56,57};
        byte[] secondA = {65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90};
        byte[] thirdA =  {97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,
                112,113,114,115,116,117,118,119,120,121,122};
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        int counter = 0;
        boolean firstCri = false; boolean secondCri = false; boolean thirdCri = false;
        byte b=0;

        while (counter < 8) {
            switch (rnd.nextInt(3)) {
                case 0: {
                    b=firstA[rnd.nextInt(10)];
                    firstCri=true;
                    break;
                }
                case 1: {
                    b=secondA[rnd.nextInt(26)];
                    secondCri=true;
                    break;
                }
                case 2: {
                    b=thirdA[rnd.nextInt(26)];
                    thirdCri=true;
                }
            }
            bs.write(b);
            counter++;
            if (counter == 8) {
                if (!(firstCri && secondCri && thirdCri)){
                    counter=0;
                    bs.reset();
                }
            }
        }

        return bs;
    }
}