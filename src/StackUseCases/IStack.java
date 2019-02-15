package StackUseCases;

public interface IStack<T> {

    void push(T t);
    T pop();
    T peak();
    int size();
    boolean isEmpty();

}
