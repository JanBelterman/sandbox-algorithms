package StackUseCases;

import java.util.LinkedList;

public class Stack<T> implements IStack<T> {

    private LinkedList<T> list;

    public Stack() {
        list = new LinkedList<>();
    }

    public void push(T t) {
        list.addFirst(t);
    }

    public T pop() {
        return list.removeFirst();
    }

    public T peak() {
        return list.getFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

}
