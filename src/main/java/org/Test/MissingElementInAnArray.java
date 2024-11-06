package org.Test;

public class MissingElementInAnArray {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            int[] numbers = {1, 2, 3, 4, 7, 6, 8};
            Arrays.sort(numbers);
            int length = numbers.length;
            for (int i = 0; i < length; i++) {
                System.out.println(numbers[i]);
            }
        }


        private static void sort(int[] arr) {
            // TODO Auto-generated method stub

        }

    }

