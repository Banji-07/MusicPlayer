package datastructures;

import model.Music;

public class Stack {
    private final int capacity;
    private int top;
    private final Music[] stackArray;

    public Stack(int capacity) {
        this.capacity = capacity;
        stackArray = new Music[capacity];
    }

    public void push(Music music) {
        stackArray[++top] = music;
    }

    public Music pop() {
        return stackArray[top--];
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public Music peek() {
        return stackArray[top];
    }
}