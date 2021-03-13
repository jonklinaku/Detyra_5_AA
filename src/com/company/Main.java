package com.company;

import java.util.Scanner;

public class Main {

    public static int[] shiftTable = new int[500];
    public static int textLength;

    public static void shiftTableGen(char[] horspoolPattern) {
        int patternLength = horspoolPattern.length;

        for (int i = 0; i < shiftTable.length; i++)
            shiftTable[i] = patternLength;
        for (int j = 0; j < patternLength - 1; j++)
            shiftTable[horspoolPattern[j]] = patternLength - 1 - j;
    }

    public static int horspool(char[] horspoolText, char[] horspoolPattern) {
        int patternLength = horspoolPattern.length;
        int i = patternLength - 1;

        while (i < textLength) {
            int k = 0;
            while (k < patternLength && horspoolPattern[patternLength - 1 - k] == horspoolText[i - k])
                k++;
            if (k == patternLength)
                return i - patternLength + 2;
            else
                i += shiftTable[horspoolText[i]];

        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ju lutem jepeni tekstin i cili ka per te u kerkuar");
        String inputText = scanner.nextLine();
        System.out.println("ju lutem jepeni patternen!");
        String pattern = scanner.nextLine();
        char[] horspoolText = inputText.toCharArray();
        char[] horspoolPattern = pattern.toCharArray();
        textLength = horspoolText.length;
        shiftTableGen(horspoolPattern);
        int ans = horspool(horspoolText, horspoolPattern);
        if (ans != -1)
            System.out.println("Patterna e kerkuar eshte gjete ne indeksin: " + ans);
        else
            System.out.println("Patterna e kerkuar nuk eshte gjetur");
/*        long start = System.nanoTime();
        for (int i = 0; i < 9999999; i++) {
            horspool(horspoolText, horspoolPattern);
        }
        long end = System.nanoTime();
        System.out.println(end - start + " miliseconds");*/
    }
}
