package org.Test;

public class CountEvenAndOdd {
    public static void main(String[] args) {
        int a=234;
        int rem=0;
        int even_count=0;
        int odd_count=0;
        while(a>0){
             rem=a%10;
            if(rem%2==0){
                even_count++;
            }else{
                odd_count++;
            }
            a=a/10;
            System.out.println("The number of even numbers"+even_count);
            System.out.println("The number of odd numbers"+odd_count);
        }
    }
}
