package DSA;

public class CirQueue {
    int[] arr;
    int cap;
    int size = 0;
    int front = 0;
    int rear = -1;

    public CirQueue(int cap) {
        this.cap = cap;
        arr = new int[cap];
    }

    public int length() {
        return size;
    }
    public boolean isFull() {
        return size==cap;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void enqueue(int e) {
        if (isFull()) {
            System.out.println("CirQueue is full!");
            return;
        }

        rear++;
        if (rear == cap)
            rear = 0;

        arr[rear] = e;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("CirQueue is empty!");
            return -9999;
        }

        int e = arr[front];
        front++;
        if (front == cap)
            front = 0;

        size--;
        return e;
    }

    public int first() {
        if (isEmpty()) {
            System.out.println("CirQueue is empty!");
            return -9999;
        }

        return arr[front];
    }
}
