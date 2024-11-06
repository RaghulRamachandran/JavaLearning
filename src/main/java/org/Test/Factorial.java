package org.Test;

public class Factorial {
    public static void main(String[] args) {
        int fact=9;
        int no=fact;
        while(fact>0){
            fact--;
            no=no*fact;
            System.out.println(no);
        }
    }
}
