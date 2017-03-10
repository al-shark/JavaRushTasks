package com.javarush.task.task36.task3608.model;

/**
 * Created by sharka on 10.03.2017.
 */
public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
}
