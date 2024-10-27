package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // O(1) < O(n) < O(k*n) < O(k*log(n)) < O(n^2) < O(2^n)
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

        OrderedArray o = new OrderedArray(new int[] {1, 34, 2, 0, 50});
        o.bubble2();

        System.out.println(Arrays.toString(o.arr));

    }
}