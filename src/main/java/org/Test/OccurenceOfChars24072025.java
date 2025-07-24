package org.Test;

public class OccurenceOfChars24072025 {
    public static void main(String[] args) {
        String b = "Ramachandran";
        int count =b.length();
        int totalCountAfterRemoveA=b.replace("a","").length();
        int totalCount=count-totalCountAfterRemoveA;
        System.out.println("Number of occurances of a is" +totalCount);


    }
}

