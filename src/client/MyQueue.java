package client;

public class MyQueue {

  private int[] elements;
  private int front;
  private int rear;
  private int size;

  public MyQueue(int capacity) {
    elements = new int[capacity];
    front = 0;
    rear = -1;
    size = 0;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == elements.length;
  }

  public int size() {
    return size;
  }

  public void enqueue(int element) {
    if (isFull()) {
      throw new IllegalStateException("Queue is full");
    }
    if (rear == elements.length - 1) {
      rear = 0;
    } else {
      rear++;
    }
    elements[rear] = element;
    size++;
  }

  public int dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue is empty");
    }
    int element = elements[front];
    if (front == elements.length - 1) {
      front = 0;
    } else {
      front++;
    }
    size--;
    return element;
  }

  public int peek() {
    if (isEmpty()) {
      throw new IllegalStateException("Queue is empty");
    }
    return elements[front];
  }
}
