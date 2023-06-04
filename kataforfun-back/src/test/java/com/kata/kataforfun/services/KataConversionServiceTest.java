package com.kata.kataforfun.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ActiveProfiles("test")
public class KataConversionServiceTest {

    @Autowired
    private KataConversionService service;

    @Test
    public void testConvertNumber_shouldReturn_when_number_isDivisibleBy3() {
        //Given
        int inputNumberDivisibleBy3 = 9;

        //When
        String result = service.convertNumber(inputNumberDivisibleBy3);

        //Then
        assertEquals("Kata", result);

    }

    @Test
    public void testConvertNumber_shouldReturn_when_number_contains3() {
        //Given
        int inputNumberContain3 = 31;

        //When
        String result = service.convertNumber(inputNumberContain3);

        //Then
        assertEquals("Kata", result);

    }

    @Test
    public void testConvertNumber_shouldReturn_when_number_isDivisibleBy3_and_contain_3() {
        //Given
        int inputNumberDivisibleAndContain3 = 33;
        //When

        String result = service.convertNumber(inputNumberDivisibleAndContain3);
        //Then

        assertEquals("KataKataKata", result);
    }

    @Test
    public void testConvertNumber_shouldReturn_when_number_isDivisibleBy5() {
        //Given
        int inputNumberDivisibleBy5 = 100;

        //When
        String result = service.convertNumber(inputNumberDivisibleBy5);

        //Then
        assertEquals("For", result);
    }

    @Test
    public void testConvertNumber_shouldReturn_when_number_contain_5() {
        //Given
        int inputNumberContain5 = 151;
        //When
        String result = service.convertNumber(inputNumberContain5);

        //Then
        assertEquals("For", result);

    }

    @Test
    public void testConvertNumber_shouldReturn_when_number_isDivisibleBy5_and_contain_5() {
        //Given
        int inputNumberContain5 = 55;
        //When
        String result = service.convertNumber(inputNumberContain5);

        //Then
        assertEquals("ForForFor", result);

    }

    @Test
    public void testConvertNumber_shouldReturnFun_when_contain_7() {
        //Given
        int inputNumber = 7;
        //When
        String result = service.convertNumber(inputNumber);
        //Then
        assertEquals("Fun", result);
    }

    @Test
    public void testConvertNumber_shouldReturnForKata_when_contain_5_and_3() {
        //Given
        int inputNumber = 53;
        //When
        String result = service.convertNumber(inputNumber);
        //Then
        assertEquals("ForKata", result);
    }

    @Test
    public void testConvertNumber_shouldReturn_and_give_high_predecence_to_divisors() {
        //Given
        int inputNumber1 = 51;
        int inputNumber2 = 15;
        //When
        String result1 = service.convertNumber(inputNumber1);
        String result2 = service.convertNumber(inputNumber2);
        //Then
        assertEquals("KataFor", result1);
        assertEquals("KataForFor", result2);
    }


    @Test
    public void testConvertNumber_shouldReturn_when_dividedBy3_or_5_and_contain_7() {
        //Given
        int inputNumber = 27;
        //When
        String result = service.convertNumber(inputNumber);
        //Then
        assertEquals("KataFun", result);
    }

    @Test
    public void testConvertNumber_shouldReturnNumberAsString_when_number_not_divisible_and_no_contain_3_or_5() {
        //Given
        int inputNumber = 1;
        //When
        String result = service.convertNumber(inputNumber);
        //Then
        assertEquals("1", result);
    }

}

