package com.finance.microfinance.service.internationalId;

public class RepetitiveNumberCalculation {
    public int repetitiveNumber(String givenNumber) {

        char[] chars = givenNumber.toCharArray();
        int counts = 1;
        for (int i = 1; i < givenNumber.length(); i++) {
            if (chars[i] == chars[0])
                counts++;
        }
        return counts;
    }
}

