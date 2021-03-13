package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class HashHorspool {
    public static int textLength;
    public static int patternLength;
    public static HashMap<Integer, Integer> shiftTable = new HashMap<>();

    public static void shiftTableGen(char[] horspoolPattern) {
        for (int j = 0; j < patternLength - 1; j++)
            shiftTable.put((int) horspoolPattern[j], patternLength - 1 - j);
    }

    public static int horspool(char[] horspoolText, char[] horspoolPattern) {
        int i = patternLength - 1;

        while (i < textLength) {
            int k = 0;


            while (k < patternLength && horspoolPattern[patternLength - 1 - k] == horspoolText[i - k])
                k++;
            if (k == patternLength)
                return i - patternLength + 2;
            else
                i += shiftTable.getOrDefault((int) horspoolText[i], patternLength);

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
        patternLength = horspoolPattern.length;
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
