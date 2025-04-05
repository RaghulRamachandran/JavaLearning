package org.Test;

import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        int a=12345;
        int b=a;
        int rev=0;
        while(a!=0) {
            rev = rev * 10 + a % 10;
            a = a / 10;
        }
             if(b==rev){
                 System.out.println("the Number is palindrome");
             }
             else{
                 System.out.println("sorry the number is not palindrome");
             }
        }
    }
