package org.Test;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string ");
        String a =sc.nextLine();
        String original_Str=a;
        String rev="";
        int length=a.length();
        for(int i=length-1;i>=0;i--){
            rev=rev+a.charAt(i);
        }if(original_Str.equals(rev)){
            System.out.println("The string you given is a palindrome"  +a);
        }else{
            System.out.println("This is not a palindrome"+a);
        }
    }}