package com.finance.microfinance.service.internationalId;

public class DigitNumberCalculation {
    public boolean digitNumberCalculate(String givenNumber) {

        byte[] array = new byte[10];
        long longGivenNumber = Long.parseLong(givenNumber);

        for (int i = 0; i < 10; i++) {
            array[i] = (byte) (longGivenNumber % 10);
            longGivenNumber = longGivenNumber / 10;
        }

        int sum = 0;
        for (int i = 9; i > 0; i--)
            sum += array[i] * (i + 1);
        int calculatedDigitCode = sum % 11;
        if (calculatedDigitCode < 2)
            return array[0] == calculatedDigitCode;
        else
            return array[0] == 11 - calculatedDigitCode;
    }
}
