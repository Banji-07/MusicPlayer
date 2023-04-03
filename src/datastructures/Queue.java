package datastructures;

import errors.QueueUnderFlowError;
import model.Music;

import java.util.Arrays;

public class Queue {
    private final Music[] queueArray;
    private int maxSize, front, rear, nItems;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new Music[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(Music music) {
        if (isFull())
            throw new IllegalStateException();
        if (rear == maxSize - 1)
            rear = -1;
        queueArray[++rear] = music;
        nItems++;
    }

    public Music remove() {
        if (isEmpty())
            throw new QueueUnderFlowError("There's currently no music in the queue.");
        Music music = queueArray[front++];
        if (front == maxSize)
            front = 0;
        nItems--;
        return music;
    }

    public Music peekFront() {
        return queueArray[front];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public int size() {
        return nItems;
    }

    public void clear() {
        front = 0;
        rear = -1;
        nItems = 0;
        Arrays.fill(queueArray, null);
    }

}