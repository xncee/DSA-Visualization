package DSA;

public class Stack {
    private int[] arr;
    private int cap;
    private int top = -1;

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

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -9999;
        }

        return arr[top];
    }
}
