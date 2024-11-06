package org.Test;

import java.util.Scanner;

public class MethodsAndConstructors {
    String name;
    int age;

    MethodsAndConstructors(String name) {
        this.name = name;
        System.out.println(name);
    }

    MethodsAndConstructors(int age) {
        this.age = age;
        System.out.println(age);
    }

    public static void Method() {
        System.out.println("what are you going to print");
        Scanner input = new Scanner(System.in);
        String word = input.next();
        System.out.println("Method");
    }
    

    public static void main(String[] args) {
        Method();
        MethodsAndConstructors A = new MethodsAndConstructors("Ram");
        MethodsAndConstructors B = new MethodsAndConstructors(25);
    }
}
