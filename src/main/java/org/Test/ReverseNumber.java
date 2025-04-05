package org.Test;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
//        Scanner input= new Scanner(System.in);
//        System.out.println("Enter the number you want to reverse :");
//        int a=input.nextInt();
//        StringBuffer ab=new StringBuffer(String.valueOf(a));
//        StringBuffer rev =ab.reverse();
//        System.out.println(rev );

        int a=1234;
        int rev=0;
        while (a!=0){
            rev=rev*10+a%10;
            a=a/10;
        }
        System.out.println(rev);
    }
}
