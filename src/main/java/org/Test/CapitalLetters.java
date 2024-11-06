package org.Test;

public class CapitalLetters {
    public static void main(String[] args) {
        // Moving capital letters to the front.
        String a = "RaMaChAnDrAn";
        StringBuilder result = new StringBuilder();
        int CapitalIndex = 0;

        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (Character.isUpperCase(ch)) {
                result.insert(CapitalIndex++, ch);
            } else {
                result.append(ch);
            }
        }
        System.out.println(result.toString());
    }
}
