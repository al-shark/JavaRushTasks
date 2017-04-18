package com.javarush.task.task29.task2909.human;

/**
 * Created by sharka on 18.04.2017.
 */
public class UniversityPerson extends Human {
    private University university;

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public UniversityPerson(String name, int age) {
        super(name, age);
    }
}
