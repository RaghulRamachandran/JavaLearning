package org.Test;

public class oddNumbers24072025 {
    public static void main(String[] args) {
       int oddCount=0;
       int evenCount=0;
       for(int i=1;i<=20;i++){
           if(i%2!=0){
               oddCount++;
           }else{
               evenCount++;
           }
       }
        System.out.println("The count of odd numbers"+oddCount);
        System.out.println("The count of even numbers"+evenCount);

    }
}
