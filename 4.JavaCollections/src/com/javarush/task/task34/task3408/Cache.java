package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if (cache.containsKey(key)) return cache.get(key);

        Constructor constructor = clazz.getConstructor(key.getClass());
        V obj = (V) constructor.newInstance(key);
        cache.put(key, obj);
        return obj;
    }

    public boolean put(V obj) {
        int cacheSize = size();
        Class objClass = obj.getClass();
        try {
            Method methodGetKey = objClass.getDeclaredMethod("getKey", null);
            methodGetKey.setAccessible(true);
            K key = (K)methodGetKey.invoke(obj, null);

            cache.put(key, obj);
            if (size() <= cacheSize){
                return false;
            }
        } catch (NoSuchMethodException e) {
            return false;
        } catch (IllegalAccessException | InvocationTargetException e) {
            return false;
        }

        return true;
    }

    public int size() {
        return cache.size();
    }
}
