package DSA;

public class Queue {
    int[] arr;
    int cap;
    int size = 0;
    int front = 0;
    int rear = -1;

    public Queue(int cap) {
        this.cap = cap;
        arr = new int[cap];
    }

    public int length() {
        //return rear-front+1;
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
            System.out.println("Queue is full!");
            return;
        }
        rear++;
        arr[rear] = e;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -9999;
        }
        size--;
        return arr[front++];
    }

    public int first() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -9999;
        }

        return arr[front];
    }
}
