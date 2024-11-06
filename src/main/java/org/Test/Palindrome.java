package org.Test;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Enter the word you want to check:");
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        if(IsPalindrome(word)){
            System.out.println("THe word is a Palindrome");
        }
        else{
            System.out.println("THe word is not a Palindrome");
        }
    }

    public static boolean IsPalindrome(String word){
        String word2="";
        for(int i=word.length()-1;i>=0;i--){
            word2+=word.charAt(i);
        }
        return word2.equals(word);
    }
}




//
