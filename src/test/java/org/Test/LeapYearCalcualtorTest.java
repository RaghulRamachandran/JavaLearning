package org.Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class LeapYearCalculatorTest {

    @Test
    void isLeapYear() {
        assertTrue(LeapYearCalculator.isLeapYear(2000));
        assertTrue(LeapYearCalculator.isLeapYear(2020));
    }
    @Test
    void isNonLeapYear(){
        assertFalse(LeapYearCalculator.isLeapYear(2021));
    }
}