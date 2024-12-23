package DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        OrderedArray o = new OrderedArray(10);
        int[] a = {50, 2, 234, 34, -10};

        //o.mergeSort(a, 0, a.length-1);
        o.selectionSort(a);
        System.out.println(Arrays.toString(a));
    }
    int [] arr;
    int size=0;
    public int binarySearch(int e) {
        int first = 0;
        int last = size - 1;

        while (first <= last) {
            int mid = (first+last) / 2;

            if (arr[mid] == e) {
                return mid;
            }
            else if (arr[mid] > e) {
                last = mid - 1;
            }
            else {
                first = mid + 1;
            }
        }

        return -1;
    }
}