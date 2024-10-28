package org.example;

import java.util.Arrays;

public class Main {


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
        OrderedArray o = new OrderedArray(new int[] {100, 5, -1, 50, 20, 0, -50, 75, 25, 10});
        o.SLEEP = 0;
        o.bubble4();

        System.out.println(o.binarySearch(5));
    }
}
