package DSA.TESTS;

import DSA.OrderedArray;
import design.Color;

import java.util.Arrays;
import java.util.Scanner;

public class SearchAlgorithmsTest implements Color {
    static int[][][] testCases = {
            {{1, 3, 5, 2, 4, 6, 9, 7, 8}, {5}, {4}},
//            {{729, 361, 881, 274, 849, 931, 837, 456, 434, 215, 2, 700, 572, 342, 556, 509, 793, 465, 102, 279, 269, 296, 297, 457, 32, 612, 776, 960, 159, 146, 168, 397, 808, 198, 213, 327, 876, 25, 216, 647, 119, 681, 421, 479, 858, 836, 848, 885, 650, 105, 95, 914, 209, 131, 75, 457, 691, 162, 368, 558, 395, 560, 444, 189, 995, 477, 612, 284, 451, 711, 826, 998, 64, 457, 627, 413, 286, 743, 773, 163, 840, 443, 229, 733, 676, 807, 182, 557, 660, 304, 38, 426, 903, 356, 298, 46, 950, 544, 738, 388}
//                    , {560}
//                    , {61}},
            {{425, 262, 487, 69, 632, 454, 378, 357, 792, 981, 723, 471, 200, 807, 643, 51, 534, 991, 374, 163}
                    , {378}
                    , {7}
            },
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
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = 1;
        double SLEEP = 0.5;
        System.out.println("Enter to Start: ");
        sc.nextLine();
        for (int[][] test: testCases) {
            int[] arr = test[0];
            int input = test[1][0];
            int expected = test[2][0];

            OrderedArray o = new OrderedArray(Arrays.copyOf(arr, arr.length));
            o.SLEEP = SLEEP;
            System.out.print("Bubble Sort: ");
            System.out.print("("+YELLOW+"COMPARING"+RESET);
            System.out.print(", "+RED+"SHOULD SWAP"+RESET);
            System.out.print(", "+GREEN_BACKGROUND+"CHECKED"+RESET+")");
            System.out.println();
            o.bubble4();


            System.out.print("Sequential Search: ");
            System.out.print("("+YELLOW+"CURRENT"+RESET);
            System.out.print(", "+GREEN_BACKGROUND+"FOUND"+RESET+")");
            int r = o.sequentialSearch(374);
            System.out.println();
            System.out.println("output: "+r);

            System.out.print("Binary Search: ");
            System.out.print("("+YELLOW+"SEARCH RANGE"+RESET);
            System.out.print(", "+CYAN_BACKGROUND+"MID"+RESET);
            System.out.print(", "+GREEN_BACKGROUND+"FOUND"+RESET+")");
            System.out.println();
            o.SLEEP = SLEEP;

            System.out.println("- TARGET: "+GREEN+input+RESET);
            int output = o.binarySearch(input);
            System.out.println();
            System.out.println("output: "+output);
            System.out.println("expected: "+expected);

            String result = String.valueOf(output==expected);
            if (result.equals("true"))
                result = GREEN+result+RESET;
            else
                result = RED+result+RESET;

            System.out.println("\nTEST-"+(n++)+": "+result);
            System.out.println("======================");
            OrderedArray.sleepFor(SLEEP);
        }
    }
}
