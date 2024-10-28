package DSA;

import java.util.Arrays;

public class BubbleSortTest {
    static int[][][] testCases = {
            { {1, 2, 3, 5, 4, 6, 7, 8, 9}, {1, 2, 3, 4, 5, 6, 7, 8, 9} }, // 1. Nearly Sorted Array
            { {5, 1, 4, 2, 8}, {1, 2, 4, 5, 8} }, // 2. Basic Unsorted Array
            { {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5} }, // 3. Already Sorted Array
            { {9, 8, 7, 6, 5}, {5, 6, 7, 8, 9} }, // 4. Reverse Sorted Array
            { {3, 1, 2, 3, 3, 0}, {0, 1, 2, 3, 3, 3} }, // 5. Array with Duplicates
            { {4, 4, 4, 4, 4}, {4, 4, 4, 4, 4} }, // 6. Array with All Elements the Same
            { {3, -1, -4, 2, 0}, {-4, -1, 0, 2, 3} }, // 7. Array with Negative Numbers
            { {5}, {5} }, // 8. Single Element Array
            { {}, {} }, // 9. Empty Array
            { {100, 5, -1, 50, 20, 0, -50, 75, 25, 10}, {-50, -1, 0, 5, 10, 20, 25, 50, 75, 100} }, // 10. Large Array
            { {4, 4, 4, 4, 4}, {4, 4, 4, 4, 4} }, // 11. All Elements the Same
    };

    public static void main(String[] args) {
        int n = 1;
        for (int[][] test: testCases) {
            int[] input = test[0];
            int[] output = test[1];
            OrderedArray.SLEEP = 0;
            OrderedArray o1 = new OrderedArray(Arrays.copyOf(input, input.length));
            o1.bubble1();
            OrderedArray o2 = new OrderedArray(Arrays.copyOf(input, input.length));
            o2.bubble2();
            OrderedArray o3 = new OrderedArray(Arrays.copyOf(input, input.length));
            o3.bubble3();
            OrderedArray o4 = new OrderedArray(Arrays.copyOf(input, input.length));
            o4.bubble4();

            System.out.println("\nTEST-"+(n++)+": "+(Arrays.equals(output, o4.arr)));
            System.out.println("======================");
        }
    }
}
