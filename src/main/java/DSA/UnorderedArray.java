package DSA;

public class UnorderedArray {
    int cap;
    int size;
    int[] arr;

    public UnorderedArray(int cap) {
        this.cap = cap;
        arr = new int[cap];
    }

    public boolean isFull() {
        return size==cap;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void addFirst(int e) {
        if (isFull()) {
            System.out.println("Array is full!");
            return;
        }

        // {1, 2, 3, _}
        for (int i=size; i>0; i--) {
            arr[i] = arr[i-1];
        }

        arr[0] = e;
        size++;
    }

    public void delFirst() {
        if (isEmpty()) {
            System.out.println("Array is empty!");
            return;
        }

        for (int i=0; i<size-1; i++) {
            arr[i] = arr[i+1];
        }

        size--;
    }

    public void addLast(int e) {
        if (isFull()) {
            System.out.println("Array is full!");
            return;
        }

        arr[size] = e;
        size++;
    }

    public void delLast() {
        if (isEmpty()) {
            System.out.println("Array is empty!");
            return;
        }

        size--;
    }

    public void addIn(int loc, int e) {
        if (isFull()) {
            System.out.println("Array is full!");
            return;
        }

        if (loc<0 || loc>size) {
            System.out.println("Invalid location!");
            return;
        }

        for (int i=size; i>loc; i--) {
            arr[i] = arr[i-1];
        }

        arr[loc] = e;
        size++;
    }

    public void delIn(int loc) {
        if (isEmpty()) {
            System.out.println("Array is empty!");
            return;
        }

        if (loc<0 || loc>=size) {
            System.out.println("Invalid location!");
            return;
        }

        for (int i=loc; i<size-1; i++) {
            arr[i] = arr[i+1];
        }

        size--;
    }

    public int sequentialSearch(int value) {
        for (int i=0; i<size; i++) {
            if (arr[i]==value) return i;
        }

        return -1;
    }
}
