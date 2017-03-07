package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];
        Solution solution;

        for (int i=0; i<2; i++) {
            solution = new Solution();
            for (int j=0; j<2; j++) solution.innerClasses[j] = solution.new InnerClass();
            solutions[i] = solution;
        }

        return solutions;
    }

    public static void main(String[] args) {

    }
}
