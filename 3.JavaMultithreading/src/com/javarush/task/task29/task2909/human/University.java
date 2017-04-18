package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private int age;
    private String name;
    private List<Student> students = new ArrayList<>();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student s : students) {
            if (s.getAverageGrade()==averageGrade) return s;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student stud;
        if (students.size()>0) {
            stud = students.get(0);
            for (int i = 1; i<students.size(); i++) {
                if (students.get(i).getAverageGrade() > stud.getAverageGrade()) stud = students.get(i);
            }
            return stud;
        }
        return null;
    }

    public Student getStudentWithMinAverageGrade() {
        Student stud;
        if (students.size()>0) {
            stud = students.get(0);
            for (int i = 1; i<students.size(); i++) {
                if (students.get(i).getAverageGrade() < stud.getAverageGrade()) stud = students.get(i);
            }
            return stud;
        }
        return null;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}