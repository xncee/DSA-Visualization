package org.example;

import java.util.Arrays;

public class Main {
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
        //        UnorderedArray a = new UnorderedArray(10);
        //        a.addFirst(10);
        //        a.addFirst(5);
        //        a.addFirst(50);
        //        a.addFirst(90);
        //        a.addLast(99);
        //        a.delLast();
        //        a.addLast(88);
        //        a.delFirst();
        //        a.addIn(0, 3);
        //        a.addIn(4, 3);
        //        a.delIn(4);
        //        System.out.println(Arrays.toString(a.arr));
        OrderedArray o = new OrderedArray(testCases[9][0]);

        o.bubble1();
    }
}
