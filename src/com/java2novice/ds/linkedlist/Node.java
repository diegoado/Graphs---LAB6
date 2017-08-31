package com.java2novice.ds.linkedlist;

class Node<T> implements Comparable<T> {

    private T value;
    private Node<T> nextRef;

    T getValue() {
        return value;
    }

    void setValue(T value) {
        this.value = value;
    }

    Node<T> getNextRef() {
        return nextRef;
    }

    void setNextRef(Node<T> ref) {
        this.nextRef = ref;
    }

    @Override
    public int compareTo(T arg) {
        return arg == this.value ? 0 : 1;
    }
}