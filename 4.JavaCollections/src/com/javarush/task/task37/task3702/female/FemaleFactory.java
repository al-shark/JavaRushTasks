package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.Human;

public class FemaleFactory {
        public Human getPerson(int age) {
            if (age < 13) return new KidGirl();
            if (age < 20) return new TeenGirl();
            return new Woman();
        }
}
