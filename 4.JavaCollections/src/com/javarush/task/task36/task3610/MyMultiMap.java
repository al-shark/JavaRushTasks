package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        int collSize = 0;
        for (Map.Entry<K,List<V>> mapEl : map.entrySet()) {
            collSize = collSize + mapEl.getValue().size();
        }
        return collSize;
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        V retValue;
        List<V> listEl;

        if (map.containsKey(key)) {
            listEl = map.get(key);
            retValue = listEl.get(listEl.size()-1);
        }
        else {
            listEl = new ArrayList();
            retValue  =null;
        }

        if (listEl.size() >= repeatCount)
            listEl.remove(0);

        listEl.add(value);

        map.put(key,listEl);

        return retValue;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        if (!map.containsKey(key)) return null;
        V elElem = map.get(key).remove(0);
        if (map.get(key).isEmpty()) {
            map.remove(key);
        }

        return elElem;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        ArrayList <V> retValues = new ArrayList<>();
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            for (V v : entry.getValue()) {
                retValues.add(v);
            }
        }

        return retValues;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        return values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}