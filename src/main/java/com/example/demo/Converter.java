package com.example.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.example.demo.Dictionary.*;

public class Converter {

    public static void main(String[] args) {
        String collect = String.join(" |", basicNumbersMap.keySet()) + " |" + String.join(" |", delimiterNumbersMap.keySet());

        String text = "У меня есть сто пять фиолетовых енотов и сорок три ежа";

        Pattern pattern = Pattern.compile("("+collect+")+");
        Matcher matcher = pattern.matcher(text);

        String result = text;

        while (matcher.find()) {
            String findingTextNumber = text.substring(matcher.start(), matcher.end());
            String numericNumber = convertAlphabeticFormToNumeric(findingTextNumber);
            result = result.replaceAll(findingTextNumber, numericNumber);
        }

        System.out.println(result);
    }

    public static String convertAlphabeticFormToNumeric (String textNumber){
        String[] words = textNumber.split(" ");
        long result = delimiterNumbersMap.getOrDefault(words[0], Long.valueOf(basicNumbersMap.get(words[0])));

        for (int i = 1; i < words.length; i++){
            if (delimiterNumbersMap.containsKey(words[i])){
                result = result * delimiterNumbersMap.get(words[i]);
            }
            else {
                result = result + basicNumbersMap.get(words[i]);
            }
        }
        return result + " ";
    }

}
