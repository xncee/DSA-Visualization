package DSA;

import design.Color;

import java.util.Arrays;

public class OrderedArray implements Color {
    int cap;
    int size;
    public int[] arr;
    String[] r;
    public static double SLEEP = 0.8;

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

    public void setColor(int from, int to, String clr) {
        for (int i=from; i<=to; i++) {
            setColor(i, clr);
        }
    }

    public void setValue(int idx, String value) {
        r[idx] = value;
        printArray(r);
    }

    public void showEffect(int idx1, int idx2, String clr) {
        setColor(idx1, clr);
        setColor(idx2, clr);
        sleepFor(SLEEP);
    }

    // The methods bubble1, bubble2, bubble3, and bubble4 represent progressively optimized versions of the Bubble Sort algorithm.
    // Each method tracks the number of comparisons (c) to demonstrate the efficiency gained with each enhancement.
    public void bubble1() {
        // Inner Loop Condition: Always iterates from 0 to size - 1.
        // Performs unnecessary comparisons even when the largest elements are already sorted at the end.
        // Best-case time complexity: O(n^2)
        // Worst-case time complexity: O(n^2)
        int c = 0;
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
        // Inner Loop Condition: Limits the range to size - 1 - i to skip already sorted elements.
        // Reduces comparisons by excluding the sorted portion of the array.
        // Best-case time complexity: O(n^2)
        // Worst-case time complexity: O(n^2)
        // Comparisons: n*(n-1)/2 (approximately half of bubble1).
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
        // Swapped Flag: Introduced to exit early if the array becomes sorted before completing all passes.
        // Inner Loop Condition: Same as bubble2.
        // Avoids unnecessary passes when no swaps occur in an iteration, further reducing comparisons.
        // Best-case time complexity: O(n) when the array is already sorted (early exit).
        // Worst-case time complexity: O(n^2)
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
        // Instead of iterating up to size - 1 - i, it tracks the last index where a swap occurred (lastSwapped).
        // Limits comparisons to this range, reducing redundant comparisons even further.
        // Best-case time complexity: O(n) (early exit).
        // Worst-case time complexity: O(n^2), though with fewer comparisons compared to bubble3.
        int c = 0;
        int end = size-1;
        int lastSwapped = end;

        for (int i=0; i<size; i++) {
            boolean swapped = false;
            int last = size-1-i;
            for (int j=0; j<end; j++) {
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
            end = lastSwapped;
        }

        System.out.println();
        System.out.println("(bubble4) c="+c);
    }

    public int sequentialSearch(int e) {
        for (int i=0; i<size; i++) {
            setColor(i, YELLOW);
            sleepFor(SLEEP);
            if (arr[i]==e) {
                setColor(i, GREEN_BACKGROUND);
                return i;
            }

            resetColor();
        }

        return -1;
    }

    public int binarySearch(int e) {
        int low = 0;
        int high = size-1;
        resetColor();
        while (low<=high) {
            // int mid = (high+low) / 2;
            // integers have a fixed size (e.g., 32 bits). If the sum of two large integers exceeds the maximum value that can be represented by that data type, it results in an overflow, causing unexpected behavior.
            int mid = low+(high-low)/2; // to avoid Integer Overflow
            // using long data type would also reduce the risk of integer overflow
            setColor(low, high, YELLOW);
            sleepFor(1);
            setColor(mid, CYAN_BACKGROUND);
            sleepFor(SLEEP);
            if (arr[low]==e) {
                // this is needed in cases where there are redundant elements [4, 4, 4, 4, 4]
                resetColor();
                setColor(low, GREEN_BACKGROUND);
                return low;
            }
            if (arr[mid]==e) {
                resetColor();
                setColor(mid, GREEN_BACKGROUND);
                return mid;
            }

            // Those are used for visualization:
            int tempLow = low; // <--
            int tempHigh = high; // <--
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

    public static void bubbleSortOnMatrix(int[][] matrix, int target) {
        // Time Complexity: O((n*m)^2)
        // Space Complexity: O(1)
        int n = matrix.length; // rows
        int m = matrix[0].length; // cols

        int end = n*m-1;
        int lastSwapped = end;
        for (int i=0; i<n*m; i++) {
            boolean swapped = false;
            for (int j=0; j<end; j++) {
                if (matrix[j / m][j % m] > matrix[(j+1) / m][(j+1) % m]) {
                    int temp = matrix[j / m][j % m];
                    matrix[j / m][j % m] = matrix[(j+1) / m][(j+1) % m];
                    matrix[(j+1) / m][(j+1) % m] = temp;

                    swapped = true;
                    lastSwapped = j;
                }
            }

            if (!swapped) break;
            end = lastSwapped;
        }
    }
    public static int[] binarySearchOnMatrix(int[][] matrix, int target) {
        // This method assumes that the matrix is sorted.
        // Time Complexity: O(log(n*m))
        // Space Complexity: O(1)
        int n = matrix.length; // rows
        int m = matrix[0].length; // cols

        int first = 0;
        int last = n*m-1;

        while (first <= last) {
            int mid = first + (last-first)/2; // Prevent integer overflow
            int r = mid / m;
            int c = mid % m;
            int midValue = matrix[r][c];

            if (midValue == target) {
                return new int[] {r, c}; // Target found
            } else if (midValue > target) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }

        return new int[] {-1, -1}; // Target not found
    }

    public static int[] staircaseSearchOnMatrix(int[][] matrix, int target) {
        // This method assumes that the matrix is sorted.
        // Time Complexity: O(n+m)
        // Space Complexity: O(1)
        // Efficient for matrices sorted row-wise and column-wise.
        // Best suited for scenarios where the matrix is not treated as a flattened array.
        int n = matrix.length; // rows
        int m = matrix[0].length; // cols

        int row = 0;
        int col = m-1;

        while (row < n && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[] {row, col}; // Target found
            }
            else if (matrix[row][col] > target) {
                col--; // move left to reduce the value.
            }
            else {
                row++; // move down to increase the value.
            }
        }

        return new int[] {-1, -1}; // Target not found
    }

    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
        // Time Complexity: O(n+m)
        // Space Complexity: O(n+m)
        int k = 0;
        int[] merged = new int[arr1.length+arr2.length];

        int i = 0;
        int j = 0;
        // Add minimum elements first
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            }
            else {
                merged[k++] = arr2[j++];
            }
        }
        // if i or j exceeds the limit, the previous loop will break and there will be left elements in one the two arrays.

        // Add remaining elements from arr1
        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }
        // Add remaining elements from arr2
        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1; // Size of left subarray
        int n2 = right - mid;   // Size of right subarray
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid+1, rightArr, 0, n2);

        // Merge the two sorted subarrays
        int k = left;
        int i = 0;
        int j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            }
            else {
                arr[k++] = rightArr[j++];
            }
        }
        // Copy remaining elements from leftArr
        while (i < leftArr.length) {
            arr[k++] = leftArr[i++];
        }
        // Copy remaining elements from rightArr
        while (j < rightArr.length) {
            arr[k++] = rightArr[j++];
        }
    }
    // {10, 5, -1, 4, 0, 6, 9, 0}
    public void mergeSort(int[] arr, int left, int right) {
        // dividing takes O(logn).
        // merging takes O(n) time at each level of recursion.
        // (where n is the size of the array)

        // Time Complexity: O(n*logn)
        // Space Complexity: O(n)
        if (left >= right) return; // Base case (stop recursion)

        int mid = left+(right-left)/2;
        // Recursive calls
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);

        // Merge the sorted halves
        merge(arr, left, mid, right);
    }

    public void selectionSort(int[] arr) {
        // Time Complexity: O(n^2)
        // Space Complexity: O(1)
        for (int i=0; i < arr.length; i++) {
            int min = i; // assume the current element is the minimum.
            for (int j=i+1; j < arr.length; j++) {
                // if a smaller element is found, update min
                if (arr[j] <= arr[min])
                    min = j;
            }
            // swap current with minimum element
            // skip unnecessary swaps
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
