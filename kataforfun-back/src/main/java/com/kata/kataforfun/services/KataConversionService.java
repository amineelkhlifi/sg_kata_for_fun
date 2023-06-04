package com.kata.kataforfun.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class KataConversionService {


    private  final Map<Character, String> conversionRules;


    @Autowired
    public KataConversionService(@Qualifier("conversionRules") Map<Character, String> conversionRules){
        this.conversionRules = conversionRules;
    }

    public String convertNumber(int numberToConvert) {
        StringBuilder result = new StringBuilder();

        if (isDivisibleBy3(numberToConvert)) {
            result.append(conversionRules.get('3'));
        }
        if (isDivisibleBy5(numberToConvert)) {
            result.append(conversionRules.get('5'));
        }
        result.append(convertToWords(numberToConvert));

        return result.length() > 0 ? result.toString() : String.valueOf(numberToConvert);
    }

    private boolean isDivisibleBy3(int numberToConvert) {
        return numberToConvert % 3 == 0;
    }

    private boolean isDivisibleBy5(int numberToConvert) {
        return numberToConvert % 5 == 0;
    }


    private String convertToWords(int numberToConvert) {
        String numberStr = String.valueOf(numberToConvert);
        return numberStr.chars()
                .mapToObj(ch -> conversionRules.getOrDefault((char) ch, ""))
                .reduce("", String::concat);
    }
}

