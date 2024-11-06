package org.Test;

import java.sql.SQLOutput;
import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);

        String name ="";
        while(name.isBlank()){
            System.out.println("Enter your name");
            name=input.nextLine();
        }
        System.out.println("Hello"+name);
}
}
