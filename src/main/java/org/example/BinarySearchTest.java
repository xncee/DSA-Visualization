package org.example;

import java.util.Arrays;

public class BinarySearchTest implements Color {
    static int[][][] testCases = {
            {{1, 3, 5, 2, 4, 6, 9, 7, 8}, {5}, {4}},        // Sorted: {1, 2, 3, 4, 5, 6, 7, 8, 9} -> Target 5 at index 4
            {{8, 5, 1, 4, 2}, {8}, {4}},                    // Sorted: {1, 2, 4, 5, 8} -> Target 8 at index 4
            {{5, 1, 3, 4, 2}, {6}, {-1}},                   // Sorted: {1, 2, 3, 4, 5} -> Target 6 not found
            {{7, 9, 6, 8, 5}, {7}, {2}},                    // Sorted: {5, 6, 7, 8, 9} -> Target 7 at index 2
            {{0, 1, 3, 2, 3, 3}, {0}, {0}},                 // Sorted: {0, 1, 2, 3, 3, 3} -> Target 0 at index 0
            {{4, 4, 4, 4, 4}, {4}, {0}},                    // Sorted: {4, 4, 4, 4, 4} -> Target 4 at index 0
            {{2, -1, 0, -4, 3}, {-4}, {0}},                 // Sorted: {-4, -1, 0, 2, 3} -> Target -4 at index 0
            {{5}, {5}, {0}},                                // Sorted: {5} -> Target 5 at index 0
            {{}, {3}, {-1}},                                // Empty array, target 3 not found
            {{25, 100, 50, 0, 10, -50, -1, 5, 20, 75}, {25}, {6}}, // Sorted: {-50, -1, 0, 5, 10, 20, 25, 50, 75, 100} -> Target 25 at index 6
    };

    public static void main(String[] args) {
        int n = 1;
        for (int[][] test: testCases) {
            int[] arr = test[0];
            int input = test[1][0];
            int expected = test[2][0];

            OrderedArray o = new OrderedArray(Arrays.copyOf(arr, arr.length));
            o.SLEEP = 0.1;
            o.bubble4();

            int output = o.binarySearch(input);
            System.out.println("target: "+input);
            System.out.println("output: "+output);
            System.out.println("expected: "+expected);

            String result = String.valueOf(output==expected);
            if (result.equals("true"))
                result = GREEN+result+RESET;
            else
                result = RED+result+RESET;

            System.out.println("\nTEST-"+(n++)+": "+result);
            System.out.println("======================");
        }
    }
}
