package com.javarush.task.task26.task2601;

/* 
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] tI = {13, 8, 15, 5, 17};
        tI=sort(tI);
    }

    public static Integer[] sort(Integer[] array) {
        Integer temp;
        for (int i=0; i<(array.length-1); i++) {
            for (int j=i+1; j<array.length; j++) {
                if (array[i]>array[j]) {
                    temp = array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        int medi = (array.length % 2 == 0) ? (array[array.length / 2 -1]+array[array.length / 2]) / 2: array[array.length / 2];

        for (int i=0; i<(array.length-1); i++) {
            for (int j=i+1; j<array.length; j++) {
                if (Math.abs((array[i]-medi)) > Math.abs((array[j]-medi))) {
                    temp = array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
                else if ((Math.abs((array[i]-medi)) == Math.abs((array[j]-medi)))) {
                    if (array[i]>array[j]) {
                        temp = array[i];
                        array[i]=array[j];
                        array[j]=temp;
                    }
                }
            }
        }
        //implement logic here
        return array;
    }
}
