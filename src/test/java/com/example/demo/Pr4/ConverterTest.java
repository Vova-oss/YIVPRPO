package com.example.demo.Pr4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    void testReplaceNumbersInTextWhenNumberInStart() {
        String result = Converter.replaceNumbersInText("сто сорок пять куриц");
        assertEquals("145 куриц", result);
    }

    @Test
    void testReplaceNumbersInTextWhenNumberInEnd() {
        String result = Converter.replaceNumbersInText("У меня около двух тысяч пяти");
        assertEquals("У меня около 2005", result);
    }

    @Test
    void testReplaceNumbersInTextWhenNumberInMiddle() {
        String result = Converter.replaceNumbersInText("У меня около миллиона рублей");
        assertEquals("У меня около 1000000 рублей", result);
    }
}