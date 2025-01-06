package org.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        Pattern pattern= Pattern.compile("My name is Ramachandran");
        Matcher matcher=pattern.matcher("My name is Ramachandran");
        boolean matchFound= matcher.find();
        if(matchFound){
            System.out.println("match found");
        }else{
            System.out.println("Mathc not found");
        }
    }
}
