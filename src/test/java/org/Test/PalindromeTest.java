package org.Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PalindromeTest {
    @Test
    void IsPalindrome(){
        assertTrue(Palindrome.IsPalindrome("level"));
        assertTrue(Palindrome.IsPalindrome("madam"));
    }

    @Test
    void IsNotPalindrome(){
        assertFalse(Palindrome.IsPalindrome("Rama"));
    }
}
  
