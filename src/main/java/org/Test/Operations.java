package org.Test;

public class Operations {

    public static void main(String[] args) {
        Calc ob = new Calc();
        int r1=ob.add(3, 5);
        int r2=ob.sub(7, 9);
        int r3=ob.multiply(8,9);
        int r4=ob.division(9,8);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
    }
}
