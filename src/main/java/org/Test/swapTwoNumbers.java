package org.Test;

public class swapTwoNumbers {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        //first logic using temp variable
//        int temp=b;
//             b=a;
//         a=temp;
//
//        System.out.println(a);
//        System.out.println(b);
        //Second logic using + and _
        System.out.println(a);
        System.out.println(b);
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println(a);
        System.out.println(b);

    }
}
