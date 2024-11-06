package org.Test;

import java.util.Arrays;
public class Integers {

    public static void main(String[] args) {
        int[] numbers = {5, 4, 8, 9};

        System.out.println("Original array:  " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("Sorted array:    "  +   Arrays.toString(numbers));
    }
}
