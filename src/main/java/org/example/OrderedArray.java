package org.example;

import java.util.Arrays;

public class OrderedArray implements Color {
    int cap;
    int size;
    int[] arr;
    String[] r;
    double SLEEP = 0.5;

    public OrderedArray(int cap) {
        this.cap = cap;
        arr = new int[cap];
        r = new String[arr.length];
    }

    public OrderedArray(int[] arr) {
        this.arr = arr;
        r = new String[arr.length];
        updateStrArray();
        size = arr.length;

    }

    public boolean isFull() {
        return size==cap;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void sleepFor(double seconds) {
        try {
            Thread.sleep((long) (seconds*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStrArray() {
        for (int i=0; i<arr.length; i++) {
            String temp = r[i];
            r[i] = String.valueOf(arr[i]);

            if (temp!=null && temp.contains(GREEN))
                setColor(i, GREEN);
        }
    }

    public void setColor(int idx, String clr) {
        if (r[idx].contains(GREEN)) {
            String[] copy = Arrays.copyOf(r, r.length);
            copy[idx] =  clr+copy[idx]+RESET;
            System.out.print("\r"+Arrays.toString(copy));
            return;
        }

        r[idx] = clr+arr[idx]+RESET;
        System.out.print("\r"+Arrays.toString(r));
    }

    public void showEffect(int idx1, int idx2, String clr) {
        setColor(idx1, clr);
        setColor(idx2, clr);
        sleepFor(SLEEP);
    }

    public void bubble1() {
        int c = 0; // c =
        for (int i=0; i<size; i++) {
            int last = size-1-i;
            for (int j=0; j<size-1; j++) {
                c++;
                showEffect(j, j+1, YELLOW);
                if (arr[j] > arr[j+1]) {
                    showEffect(j, j+1, RED);
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    updateStrArray();
                }
                else {
                    showEffect(j, j+1, CYAN);
                }
                setColor(j, RESET);
            }
            setColor(last, GREEN);
        }
        System.out.println();
        System.out.println("(bubble1) c="+c);
    }

    public void bubble2() {
        int c = 0;
        for (int i=0; i<size; i++) {
            /*
            in each iteration of the outer-loop,
            the largest element will be at the end, so no need to compare it again.

            j<size-1 --> j<size-1-i
             */
            int last = size-1-i;
            for (int j=0; j<size-1-i; j++) { // <--
                c++;
                showEffect(j, j+1, YELLOW);
                if (arr[j] > arr[j+1]) {
                    showEffect(j, j+1, RED);
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    updateStrArray();
                }
                else {
                    showEffect(j, j+1, CYAN);
                }

                setColor(j, RESET);
            }
            setColor(last, GREEN);
        }

        System.out.println();
        System.out.println("(bubble2) c="+c);
    }

    public void bubble3() {
        // j<size-1-i & swapped boolean flag
        int c = 0;
        for (int i=0; i<size; i++) {
            boolean swapped = false; // <--
            int last = size-1-i;
            for (int j=0; j<size-1-i; j++) { // <--
                c++;
                showEffect(j, j+1, YELLOW);
                if (arr[j] > arr[j+1]) {
                    showEffect(j, j+1, RED);
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                    updateStrArray();
                }
                else {
                    showEffect(j, j+1, CYAN);
                }
                setColor(j, RESET);
            }
            setColor(last, GREEN);

            if (!swapped) break; // <--
        }

        System.out.println();
        System.out.println("(bubble3) c="+c);
    }

    public void bubble4() {
        int c = 0;
        int max = size-1;
        int lastSwapped = size-1;
        // keeping track of last swapped element to reduce iterations.
        for (int i=0; i<size; i++) {
            //boolean swapped = false;
            int last = size-1-i;
            for (int j=0; j<max; j++) { // <--
                c++;
                showEffect(j, j+1, YELLOW);
                if (arr[j] > arr[j+1]) {
                    showEffect(j, j+1, RED);
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //swapped = true;
                    lastSwapped = j; // <--
                    updateStrArray();
                }
                else {
                    showEffect(j, j+1, CYAN);
                }
                setColor(j, RESET);
            }
            setColor(last, GREEN);
            if (max==lastSwapped) break; // you can either use this or swapped boolean flag
            //if (!swapped) break;
            max = lastSwapped; // <--
        }

        System.out.println();
        System.out.println("(bubble4) c="+c);
    }


}
