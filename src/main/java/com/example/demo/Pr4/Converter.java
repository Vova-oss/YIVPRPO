package com.example.demo.Pr4;

import org.apache.logging.log4j.util.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.example.demo.Pr4.Dictionary.basicNumbersMap;
import static com.example.demo.Pr4.Dictionary.delimiterNumbersMap;

public class Converter {


    public static String replaceNumbersInText(String text) {
        String collect = basicNumbersMap.keySet().stream().sorted((o1, o2) -> Integer.compare(o2.length(), o1.length())).collect(Collectors.joining("|"))
                + "|"
                + delimiterNumbersMap.keySet().stream().sorted((o1, o2) -> Integer.compare(o2.length(), o1.length())).collect(Collectors.joining("|"));

        Pattern pattern = Pattern.compile("("+ collect + ")" + "(\s*(" + collect + "))*");
        Matcher matcher = pattern.matcher(text);

        String result = text;

        while (matcher.find()) {
            String findingTextNumber = text.substring(matcher.start(), matcher.end());
            String numericNumber = convertAlphabeticFormToNumeric(findingTextNumber);
            result = result.replaceAll(findingTextNumber, numericNumber);
        }

        return result;
    }

    private static String convertAlphabeticFormToNumeric(String textNumber) {
        List<String> words = Arrays.stream(textNumber.split(" "))
                .filter(Strings::isNotEmpty)
                .toList();

        long result;

        if (delimiterNumbersMap.containsKey(words.get(0)))
            result = delimiterNumbersMap.get(words.get(0));
        else result = basicNumbersMap.get(words.get(0));

        for (int i = 1; i < words.size(); i++) {
            if (delimiterNumbersMap.containsKey(words.get(i)))
                result = result * delimiterNumbersMap.get(words.get(i));
            else
                result = result + basicNumbersMap.get(words.get(i));
        }

        return String.valueOf(result);
    }

}
