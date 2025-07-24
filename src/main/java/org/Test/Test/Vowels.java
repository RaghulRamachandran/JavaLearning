package org.Test.Test;

public class Vowels {

    public static void main(String[] args) {
        String a = "aeiouRam";
        int count=0;
        for(int i=0;i<a.length();i++){
            char ch=a.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            }}
        if(count>0){
                System.out.println("Count of vowels "+count);
            }else{
                System.out.println("not a vowel"+count);
            }
        }
    }