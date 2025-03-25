package org.Test;

import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int a= sc.nextInt();
        int original_a=a;
        int rev=0;
        while(a!=0) {
            rev = rev * 10 + a % 10;
            a = a / 10;
        }
             if(original_a==rev){
                 System.out.println("the Number is palindrome");
             }
             else{
                 System.out.println("sorry the number is not palindrome");
             }
        }
    }
