package org.Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddorEvenTest {

    @Test
    void isEven() {
        assertTrue(OddorEven.isEven(8));
        assertTrue(OddorEven.isEven(6));
    }

    @Test
    void isNotEven(){
        assertFalse(OddorEven.isEven(10));
    }
}