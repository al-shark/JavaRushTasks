package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

public class AmigoSet <E> extends AbstractSet implements Cloneable, Serializable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

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
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
