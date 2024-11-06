package org.Test;

public class MethodOverloading {
    public static void main(String[] args) {
        int x=add(1,2,4);
        System.out.println(x);
    }static int add(int a,int b){
        System.out.println("This is a noramal method");
        return a+b;
    }static int add(int a,int b,int c){
        System.out.println("This is overloaded method 1");
        return a+b+c;

    }
}
