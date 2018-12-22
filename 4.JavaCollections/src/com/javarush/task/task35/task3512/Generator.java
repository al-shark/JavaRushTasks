package com.javarush.task.task35.task3512;

public class Generator<T> {
    private Class<T> classType;

    public Generator(Class<T> classType) {
        this.classType = classType;
    }

    T newInstance() throws InstantiationException,IllegalAccessException {
        return classType.newInstance();
    }
}
