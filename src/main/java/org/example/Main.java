package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        int[] unsortedArray = generateUnsortedArray(20);

        // Print the generated unsorted array
        System.out.println("Unsorted Array: " + Arrays.toString(unsortedArray));
    }

    // Method to generate an unsorted array of a specified length
    private static int[] generateUnsortedArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000) + 1; // Random values between 1 and 1000
        }

        return arr;
    }
}
//public class Main {
//    public static void main(String[] args) {
//        int[] unsortedArray = generateUnsortedArray(20);
//
//        // Print the generated unsorted array with a specific width per line
//        printArrayWithWidth(unsortedArray, 10); // Print 10 elements per line
//    }
//
//    private static int[] generateUnsortedArray(int size) {
//        Random random = new Random();
//        int[] arr = new int[size];
//
//        for (int i = 0; i < size; i++) {
//            arr[i] = random.nextInt(1000) + 1; // Random values between 1 and 1000
//        }
//
//        return arr;
//    }
//
//    private static void printArrayWithWidth(int[] array, int width) {
//        for (int i = 0; i < array.length; i++) {
//            // Print the element with a width of 5 characters
//            System.out.printf("%5d ", array[i]); // Adjust the width here if needed
//
//            // Print a newline after every `width` elements
//            if ((i + 1) % width == 0) {
//                System.out.println();
//            }
//        }
//
//        // Print a new line at the end if the last line is not complete
//        if (array.length % width != 0) {
//            System.out.println();
//        }
//    }
//}
