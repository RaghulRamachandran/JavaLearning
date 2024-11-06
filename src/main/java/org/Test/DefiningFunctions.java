package org.Test;

import java.util.Scanner;

public class DefiningFunctions {

    public static void developerteatime(){
        System.out.println("Waiting for Developer Tea Time");
        System.out.println("Need a random word for announce tea break");
        Scanner input=new Scanner(System.in);
        input.next();
        System.out.println("Its developer tea time");
    }
    public static void main(String[] args) {
        developerteatime();
    }}