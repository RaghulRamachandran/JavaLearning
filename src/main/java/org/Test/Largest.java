package org.Test;

public class Largest {
    public static void main(String[] args) {
           String a="RamaChanDrAN";
           int upperCount=0;
           int lowerCount=0;

           for(int i=0;i<a.length();i++){
               char ch=a.charAt(i);
               if(Character.isUpperCase(ch)){
                   upperCount++;
               } else if (Character.isLowerCase(ch)) {
                   lowerCount++;
               }
           }
        System.out.println("Upper case"+upperCount);
        System.out.println("lower case"+lowerCount);
    }
}
