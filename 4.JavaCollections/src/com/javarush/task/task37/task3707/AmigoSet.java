package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet <E> extends AbstractSet implements Cloneable, Serializable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException{
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(map.size());
        objectOutputStream.writeInt(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        objectOutputStream.writeFloat(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
        for (E e: map.keySet()) {
            objectOutputStream.writeObject(e);
        }
    }
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int size =  objectInputStream.readInt();
        int capacity = objectInputStream.readInt();
        float loadFactor = objectInputStream.readFloat();
        map = new HashMap(capacity,loadFactor);
        for (int i = 0; i <size ; i++) {
            map.put((E) objectInputStream.readObject(),PRESENT);
            }
    }

    @Override
    public Object clone() throws InternalError {
        try {
            AmigoSet amigo = new AmigoSet<>();
            amigo.map.putAll((Map) this.map.clone());
            return amigo;
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    @Override
    public boolean remove(Object o) {
        if (map.remove(o) == null) return false;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    public boolean add(Object e) {
        return map.put((E) e, PRESENT)==null;
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap<>(Math.max((int) (collection.size()/.75f) + 1, 16));
        addAll(collection);
    }

    public AmigoSet() {
        this.map = new HashMap();
    }

    @Override
    public Iterator <E> iterator() {
        return (Iterator <E> ) map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }
}
