package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

public class AmigoSet <E> extends AbstractSet implements Cloneable, Serializable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

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
