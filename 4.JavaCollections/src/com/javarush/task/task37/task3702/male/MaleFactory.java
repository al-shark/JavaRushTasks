package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.Human;

public class MaleFactory {
    public Human getPerson(int age) {
        if (age < 13) return new KidBoy();
        if (age < 20) return new TeenBoy();
        return new Man();
    }
}
