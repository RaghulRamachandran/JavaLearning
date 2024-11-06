package org.Test;

import java.time.LocalDate;
import java.time.Period;

public class HundredDays {
    public static String days(LocalDate today) {
        Period hundredDays = Period.ofDays(100);
        return today.plus(hundredDays).toString();
    }

    public static void main(String[] args) {
        System.out.println(days(LocalDate.now()));
    }
}