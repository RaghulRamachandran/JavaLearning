package org.Test;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HundredDaysTest {
    @Test
    public void testDays() {
        LocalDate today = LocalDate.of(2024, 10, 21);
        String  expectedDate = LocalDate.of(2025, 01, 29).toString();
        String result = HundredDays.days(today);
        assertEquals(expectedDate, result);
    }

    @Test
    public void testFebruary2025() {
        LocalDate today = LocalDate.of(2025, 02, 01);
        String  expectedDate = LocalDate.of(2025, 05, 12).toString();
        String result = HundredDays.days(today);
        assertEquals(expectedDate, result);
    }

    @Test
    public void testFebruary2028() {
        LocalDate today = LocalDate.of(2028, 02, 01);
        String  expectedDate = LocalDate.of(2028, 05, 11).toString();
        String result = HundredDays.days(today);
        assertEquals(expectedDate, result);
    }
}
