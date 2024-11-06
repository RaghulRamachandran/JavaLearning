package org.Test;

import java.util.Scanner;

public class LeapYearCalculator {
    public static void main(String[] args) {
        System.out.println("Enter the year you want to calculate");
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();

        if(isLeapYear(n)){
            System.out.println("The Given year is a leap year");
        }
        else{
            System.out.println("The given year is not a leap year");
        }
    }

    public static boolean isLeapYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("Year cannot be negative");
        }
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

