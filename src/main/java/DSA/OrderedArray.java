package DSA;

import java.util.Arrays;

public class OrderedArray implements Color {
    int cap;
    int size;
    int[] arr;
    String[] r;
    static double SLEEP = 0.8;

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

    public static void sleepFor(double seconds) {
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

            if (temp!=null && temp.contains(GREEN_BACKGROUND))
                setColor(i, GREEN_BACKGROUND);
        }
    }

    private static void printArray(String[] array) {
        System.out.print("\r"+Arrays.toString(array));
    }

    public void resetColor() {
        for (int i=0; i<arr.length; i++) {
            r[i] = String.valueOf(arr[i]);
        }
    }
    public void setColor(int idx, String clr) {
        int width = 7;
        if (r[idx].contains(GREEN_BACKGROUND)) {
            String[] copy = Arrays.copyOf(r, r.length);
            copy[idx] =  clr+copy[idx]+RESET;
            printArray(copy);
            return;
        }

        r[idx] = clr+arr[idx]+RESET;
        printArray(r);
    }

    public void showEffect(int idx1, int idx2, String clr) {
        setColor(idx1, clr);
        setColor(idx2, clr);
        sleepFor(SLEEP);
    }

    public void bubble1() {
        int c = 0; // Represents the number of comparisons made
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
                setColor(j, RESET);
            }
            setColor(last, GREEN_BACKGROUND);
        }
        setColor(0, size-1, GREEN_BACKGROUND);

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

                setColor(j, RESET);
            }
            setColor(last, GREEN_BACKGROUND);
        }
        setColor(0, size-1, GREEN_BACKGROUND);

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
                setColor(j, RESET);
            }
            setColor(last, GREEN_BACKGROUND);

            if (!swapped) {
                setColor(0, last-1, GREEN_BACKGROUND);
                break; // <--
            }
        }

        System.out.println();
        System.out.println("(bubble3) c="+c);
    }

    public void bubble4() {
        int c = 0;
        int max = size-1;
        int lastSwapped = max;

        for (int i=0; i<size; i++) { // i=1
            boolean swapped = false;
            int last = size-1-i;
            for (int j=0; j<max; j++) {
                c++;
                showEffect(j, j+1, YELLOW);
                if (arr[j]>arr[j+1]) {
                    showEffect(j, j+1, RED);
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                    lastSwapped = j;
                    swapped = true;
                    updateStrArray();
                }
                setColor(j, RESET);
            }
            setColor(last, GREEN_BACKGROUND);

            if (!swapped) {
                setColor(0, last-1, GREEN_BACKGROUND);
                break; // <--
            }
            max = lastSwapped;
        }

        System.out.println();
        System.out.println("(bubble4) c="+c);
    }
    public void setColor(int from, int to, String clr) {
        for (int i=from; i<=to; i++) {
            setColor(i, clr);
        }
    }

    public void setValue(int idx, String value) {
        r[idx] = value;
        printArray(r);
    }
    public int binarySearch(int e) {
        int low = 0;
        int high = size-1;
        resetColor();
        while (low<=high) {
            //int mid = (high+low) / 2;
            // integers have a fixed size (e.g., 32 bits). If the sum of two large integers exceeds the maximum value that can be represented by that data type, it results in an overflow, causing unexpected behavior.
            int mid = low+(high-low)/2; // to avoid Integer Overflow
            // using long data type would also reduce the risk of integer overflow
            setColor(low, high, YELLOW);
            sleepFor(1);
            setColor(mid, CYAN_BACKGROUND);
            sleepFor(SLEEP);
            if (arr[low]==e) {
                // this is needed in cases where there are redundant elements [4, 4, 4, 4, 4]
                setColor(low, GREEN);
                return low;
            }
            if (arr[mid]==e) {
                resetColor();
                setColor(mid, GREEN_BACKGROUND);
                return mid;
            }

            int tempLow = low;
            int tempHigh = high;
            if (arr[mid] > e) {
                high = mid-1;
                setValue(mid, RED+"<--"+RESET);
                sleepFor(SLEEP);
                setValue(mid, String.valueOf(mid));
                setColor(mid, RESET);
            }
            else {
                low = mid+1;
                setValue(mid, RED+"-->"+RESET);
                sleepFor(SLEEP);
                setValue(mid, String.valueOf(mid));
                setColor(mid, RESET);
            }
            setColor(tempLow, tempHigh, RESET);
        }

        return -1;
    }
}
