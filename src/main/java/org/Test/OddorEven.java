package org.Test;

import java.util.Scanner;

public class OddorEven {
    public static void main(String[] args) {
        Scanner n=new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number=n.nextInt();
        if(isEven(number)){
            System.out.println("Given number is even");
        }
        else{
            System.out.println("GIven number is Odd");
        }
    }

    static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
