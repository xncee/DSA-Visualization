package DSA;

public class Stack {
    int[] arr;
    int cap;
    int top;

    public Stack(int cap) {
        this.cap = cap;
        arr = new int[cap];
    }

    public boolean isEmpty() {
        return top==-1;
    }

    public boolean isFull() {
        return top+1==cap;
    }

    public int length() {
        return top+1;
    }

    public void push(int e) {
        if (isFull()) {
            System.out.println("Stack is full.");
            return;
        }

        top++;
        arr[top] = e;
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -9999;
        }

        return arr[top--];
    }

    public int peak() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -9999;
        }

        return arr[top];
    }
}
