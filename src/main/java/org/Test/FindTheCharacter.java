package org.Test;

import java.util.Scanner;

public class FindTheCharacter {
    public static void main(String[] args) {
        System.out.println("ENter the Name of the Student");
        Scanner input=new Scanner(System.in);

         String Character=input.next();
         int length=Character.length();
            System.out.println("The number of characters in the name is "+ length);
        System.out.println("Enter the Index of the character you want to seperate");
        Integer index= Integer.valueOf(input.next());
        
        try {
            System.out.println(Character.charAt(index - 1));
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("Please ENter Value within"+ length);
             index= Integer.valueOf(input.next());
            System.out.println(Character.charAt(index - 1));

        }






    }
}
