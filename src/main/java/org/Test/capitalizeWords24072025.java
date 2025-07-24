package org.Test;

public class capitalizeWords24072025 {
    public static void main(String[] args) {
        String input = "hello good morning";
        String[] words = input.split(" ");
        String result = "";
        for (String word : words) {
            String first = word.substring(0, 1).toUpperCase();
            String rest = word.substring(1).toLowerCase();
            result += first + rest + " ";
        }
        System.out.println(result.trim());
    }
}

