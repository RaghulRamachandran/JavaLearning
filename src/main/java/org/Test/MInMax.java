package org.Test;

public class MInMax {
    public static void main(String[] args) {
        int number[]={20,30,10,90,70,67,110};
        int max=number[0];
        int min=number[0];
        for(int i=0;i< number.length;i++){
            if(number[i]>max){
                max=number[i];
            } else if (number[i]<min) {
                min=number[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
        
    }
}
