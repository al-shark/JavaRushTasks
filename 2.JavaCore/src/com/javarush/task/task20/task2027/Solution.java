package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> w = detectAllWords(crossword, "home", "same","agpe","vorg","hvok","nar","darr","kerpo","usameo");
        for (Word x : w) System.out.println(x.toString());

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {

        List<Word> wList = new ArrayList<>();
        int wStartX=0,wStartY=0,wEndX=0,wEndY=0;
        int xSize=crossword[0].length;
        int ySize=crossword.length;
        boolean isFound;
        int wordLength=0;
        String testWord;
        Word oneWord;

        for (String x : words) {

            isFound=false;
            wordLength=x.length();
            testWord="";

            extloop:
            for (int i=0; i<ySize; i++) {
                for (int j=0; j<xSize; j++){
                    if ((int) x.charAt(0) == crossword[i][j]) {
                        wStartX=j;
                        wStartY=i;
                        testWord=x.substring(0,1);
                        if (j+wordLength-1 < xSize) {
                            wEndX=j+wordLength-1;
                            wEndY=i;
                            for (int counter=1; counter<wordLength; counter++) testWord=testWord+String.valueOf((char)crossword[i][j+counter]);
                            if (testWord.equals(x)) {
                                oneWord = new Word(x);
                                oneWord.setStartPoint(wStartX,wStartY);
                                oneWord.setEndPoint(wEndX,wEndY);
                                wList.add(oneWord);
                            }
                            //right
                        }
                        testWord=x.substring(0,1);
                        if (i+wordLength-1 < ySize) {
                            wEndX=j;
                            wEndY=i+wordLength-1;
                            for (int counter=1; counter<wordLength; counter++) testWord=testWord+String.valueOf((char)crossword[i+counter][j]);
                            if (testWord.equals(x)) {
                                oneWord = new Word(x);
                                oneWord.setStartPoint(wStartX,wStartY);
                                oneWord.setEndPoint(wEndX,wEndY);
                                wList.add(oneWord);
                            }
                            //down
                        }
                        testWord=x.substring(0,1);
                        if (j-wordLength+1 >=0) {
                            wEndX=j-wordLength+1;
                            wEndY=i;
                            for (int counter=1; counter<wordLength; counter++) testWord=testWord+String.valueOf((char)crossword[i][j-counter]);
                            if (testWord.equals(x)) {
                                oneWord = new Word(x);
                                oneWord.setStartPoint(wStartX,wStartY);
                                oneWord.setEndPoint(wEndX,wEndY);
                                wList.add(oneWord);
                            }
                            //left
                        }
                        testWord=x.substring(0,1);
                        if (i-wordLength+1 >=0) {
                            wEndX=j;
                            wEndY=i-wordLength+1;
                            for (int counter=1; counter<wordLength; counter++) testWord=testWord+String.valueOf((char)crossword[i-counter][j]);
                            if (testWord.equals(x)) {
                                oneWord = new Word(x);
                                oneWord.setStartPoint(wStartX,wStartY);
                                oneWord.setEndPoint(wEndX,wEndY);
                                wList.add(oneWord);
                            }
                            //up
                        }
                        testWord=x.substring(0,1);
                        if ((j+wordLength-1 < xSize) && (i+wordLength-1 < ySize)) {
                            wEndX=j+wordLength-1;
                            wEndY=i+wordLength-1;
                            for (int counter=1; counter<wordLength; counter++) testWord=testWord+String.valueOf((char)crossword[i+counter][j+counter]);
                            if (testWord.equals(x)) {
                                oneWord = new Word(x);
                                oneWord.setStartPoint(wStartX,wStartY);
                                oneWord.setEndPoint(wEndX,wEndY);
                                wList.add(oneWord);
                            }
                            //down - right
                        }
                        testWord=x.substring(0,1);
                        if ((j-wordLength+1 >=0) &&(i+wordLength-1 < ySize)) {
                            wEndX=j-wordLength+1;
                            wEndY=i+wordLength-1;
                            for (int counter=1; counter<wordLength; counter++) testWord=testWord+String.valueOf((char)crossword[i+counter][j-counter]);
                            if (testWord.equals(x)) {
                                oneWord = new Word(x);
                                oneWord.setStartPoint(wStartX,wStartY);
                                oneWord.setEndPoint(wEndX,wEndY);
                                wList.add(oneWord);
                            }
                            //down - left
                        }
                        testWord=x.substring(0,1);
                        if ((j-wordLength+1 >=0) && (i-wordLength+1 >=0)) {
                            wEndX=j-wordLength+1;
                            wEndY=i-wordLength+1;
                            for (int counter=1; counter<wordLength; counter++) testWord=testWord+String.valueOf((char)crossword[i-counter][j-counter]);
                            if (testWord.equals(x)) {
                                oneWord = new Word(x);
                                oneWord.setStartPoint(wStartX,wStartY);
                                oneWord.setEndPoint(wEndX,wEndY);
                                wList.add(oneWord);
                            }
                            //up - left
                        }
                        testWord=x.substring(0,1);
                        if ((j+wordLength-1 < xSize) && (i-wordLength+1 >=0)) {
                            wEndX=j+wordLength-1;
                            wEndY=i-wordLength+1;
                            for (int counter=1; counter<wordLength; counter++) testWord=testWord+String.valueOf((char)crossword[i-counter][j+counter]);
                            if (testWord.equals(x)) {
                                oneWord = new Word(x);
                                oneWord.setStartPoint(wStartX,wStartY);
                                oneWord.setEndPoint(wEndX,wEndY);
                                wList.add(oneWord);
                            }
                            //up - right
                        }
                    }
                }
            }
        }
        return wList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
