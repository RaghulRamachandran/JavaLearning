package org.Test;

import java.util.Scanner;

public class loops {
    public static void main(String[] args) {
        int number;
        System.out.println("Enter the number to Mulitply");
        Scanner sc=new Scanner(System.in);
        number=sc.nextInt();
        for(int i=1;i<=10;i++ ){
            System.out.println(number+"*"+i+"="+(number*i));
        }

}}
