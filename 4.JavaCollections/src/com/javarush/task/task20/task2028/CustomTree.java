package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Serializable, Cloneable {
    Entry<String> root = new Entry<>("Root");

    private void restoreTree(){
        Queue<Entry> queue = new LinkedList<>();
        Entry<String> parent = root;
        do {
            if (!queue.isEmpty()) parent = queue.poll();
            if (parent.leftChild!=null) queue.add(parent.leftChild);
            else parent.availableToAddLeftChildren = true;
            if (parent.rightChild!=null) queue.add(parent.rightChild);
            else parent.availableToAddRightChildren = true;
        } while (!queue.isEmpty());
    }
    private boolean addChild(Entry<String> parent, Entry<String> child) {
        Queue<Entry> queue = new LinkedList<>();
        do {
            if (parent!=null) {
                parent.checkChildren();
                boolean searchCrit = !parent.isAvailableToAddChildren();
            if (searchCrit) {
                queue.add(parent.leftChild);
                queue.add(parent.rightChild);
                parent = queue.poll();
            }
            else {
                child.parent = parent;
                child.lineNumber = parent.lineNumber+1;
                if (parent.leftChild == null) parent.leftChild = child;
                else parent.rightChild = child;
                return true;
            }} else parent = queue.poll();;
        } while (!queue.isEmpty());
        return false;
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public boolean add(String element) {
        Entry<String> child = new Entry<>(element);
        if (!addChild(root,child)) {
            restoreTree();
            addChild(root,child);
        }
        return true;
    }

    @Override
    public int size() {
        Queue<Entry> queue = new LinkedList<>();
        Entry<String> parent = root;
        int entrySize = 0;
        do {
            if (!queue.isEmpty()) parent = queue.poll();
            if (parent.leftChild!=null) {
                queue.add(parent.leftChild);
                entrySize++;
            }
            if (parent.rightChild!=null) {
                queue.add(parent.rightChild);
                entrySize++;
            }
        } while (!queue.isEmpty());

        return entrySize;
    }

    public String getParent(String s) {
        Queue<Entry> queue = new LinkedList<>();
        Entry<String> parent = root;
        String parentStr = "";
        do {
            if (!queue.isEmpty()) parent = queue.poll();
            if (s.equals(parent.elementName)) {
                parentStr = parent.parent !=null ? parent.parent.elementName : null;
                break;
            }
            if (parent.leftChild!=null) {
                queue.add(parent.leftChild);
            }
            if (parent.rightChild!=null) {
                queue.add(parent.rightChild);
            }
        } while (!queue.isEmpty());

        return parentStr;
    }

    @Override
    public boolean remove(Object o) {
        if (!"String".equals(o.getClass().getSimpleName())) throw new UnsupportedOperationException();
        String element = (String) o;
        Queue<Entry> queue = new LinkedList<>();
        Entry<String> parent = root;

        do {
            if (!queue.isEmpty()) parent = queue.poll();
            if (element.equals(parent.elementName)) {
                parent = parent.parent;
                break;
            }
            if (parent.leftChild!=null) {
                queue.add(parent.leftChild);
            }
            if (parent.rightChild!=null) {
                queue.add(parent.rightChild);
            }
        } while (!queue.isEmpty());

        if (parent == null) return false;
        if (parent.leftChild == null) {
            parent.rightChild = null;
            return true;
        }

        if (element.equals(parent.leftChild.elementName)) {
            parent.leftChild = null;
        }
        else {
            parent.rightChild = null;
        }
        return true;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        void checkChildren() {
            if (leftChild != null) availableToAddLeftChildren = false;
            if (rightChild != null) availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddRightChildren || availableToAddLeftChildren;
        }

    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

}