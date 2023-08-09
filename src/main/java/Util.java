package com.bnp.pf.transformation.genesys.reader.service;

import java.util.*;

public class Util {
    static int nbr1=0, nbr2=1, nbr3;
    static void buzz() {
        for (int i = 1; i <= 100; i++) {
            final boolean divideBy3 = i % 3 == 0;
            final boolean divideBy5 = i % 5 == 0;
            if (divideBy3 && divideBy5) {
                System.out.println("FizzBuzz");
            } else if (divideBy3) {
                System.out.println("Fizz");
            } else if (divideBy5) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    static void firstNumber() {
        int p = 0, i;
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < 200; j++) {
            for (i = 1; i <= j; i++) {
                if (j % i == 0) {
                    p++;
                }
            }
            if (p == 2) {
                list.add(j);
            }
            p = 0;
        }

        int i1 = 0;
        while (i1 < list.size()) {
            i1++;
            Integer firstNumber = list.get(i1);
            if (list.size() > ++i1) {
                System.out.println(firstNumber + "&" + list.get(i1) + " sont des nombre premier.");
            } else {
                System.out.println(firstNumber + " sont des nombre premier.");
            }
        }
    }

    static void printVerticallySentence(String[] sentences) {
        printWordsVertically(sentences);
    }

    /* These next two methods are relics of my initial implementation
       You can adjust for the use of 2d arrays and only need 1 method. */
    public static int wordCount(String input) {
        return input.trim().split("\\s+").length;
    }

    public static int longestWordCount(String[] input) {
        int result = 0;

        for (String s : input) {
            if (result < wordCount(s)) {
                result = wordCount(s);
            }
        }

        return result;
    }

    static void fiboUntil(int count){
        //afficher les N premiers nombre Fibonacci
        int fib = 0;
        for(int i = 1 ; i <= count ; i++) {//commencer de n=1
            fib = fib(i);
            if (fib <= count) {
                System.out.println(i + ": " + fib);
            }
        }
    }

   /* static void fibo(int count){
        int nbr1=0, nbr2=1, nbr3, i;
        //afficher 0 et 1
        System.out.print(nbr1+" "+nbr2);

        //La boucle commence par 2 car 0 et 1 sont deja affiches
        for(i=2; i<count; ++i)
        {
            nbr3 = nbr1 + nbr2;
            nbr1 = nbr2;
            nbr2 = nbr3;
            System.out.print(" "+nbr3);
        }
    }*/

    static void fibo(int count){
        //afficher les N premiers nombre Fibonacci
        for(int i = 1 ; i <= count ; i++)//commencer de n=1
            System.out.println(i + ": " + fib(i));
    }

    private static int fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }

    static void displayFibonacci(int c){
        if(c > 0){
            nbr3 = nbr1 + nbr2;
            nbr1 = nbr2;
            nbr2 = nbr3;
            System.out.print(" "+nbr3);
            displayFibonacci(c-1);
        }
    }

    static void fiboRecu(int c){
        //print 0 and 1
        System.out.print(nbr1+" "+nbr2);
        //deduire 2 car 0 et 1 sont deja affiches
        displayFibonacci(c-2);
    }

    static void countingWords(String s){
        String a[] = s.split(" ");
        Map<Integer, Integer> words = new HashMap<>();
        for (String str : a) {
            if (words.containsKey(str.length())) {
                words.put(str.length(), 1 + words.get(str));
            } else {
                words.put(str.length(), 1);
            }
        }
        System.out.println(words);
    }

    public static String
    removeConsecutiveDuplicates(String input, Integer length)
    {
        if (input.length() <= 1)
            return input;
        if (input.charAt(0) == input.charAt(1))
            return removeConsecutiveDuplicates(
                    input.substring(1),length);
        else
            return input.charAt(0)
                    + removeConsecutiveDuplicates(
                    input.substring(1),length);
    }

    static void remove3ConsecutiveDuplicates(String str)
    {
        Vector<Character> v = new Vector<>();
        for (int i = 0; i < str.length(); ++i)
        {
            v.add(str.charAt(i));

            if (v.size() > 2)
            {
                int sz = v.size();

                // removing three consecutive duplicates
                if (v.get(sz - 1) == v.get(sz - 2) &&
                        v.get(sz - 2) == v.get(sz - 3))
                {
                    v.setSize(sz - 2); // Removing three characters
                    // from the string
                }
            }
        }

        // printing the string final string
        for (int i = 0; i < v.size(); ++i)
            System.out.print(v.get(i));
    }

    public static void printWordsVertically(String[] input) {
        int longestWordCount = longestWordCount(input);
        int spacesBetweenColumns = 1; // use needed int, or pass as argument
        String formatSpecifier = "%-12s";
        String[][] words = convertToWordArray(input);

        for (int i = 0; i < longestWordCount; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i < words[j].length) {
                    System.out.printf(formatSpecifier, words[j][i]);
                } else {
                    System.out.printf(formatSpecifier, "");
                }
            }
            System.out.println();
        }
    }

    public static String[][] convertToWordArray(String[] input) {
        String[][] result = new String[input.length][];

        for (int i = 0; i < result.length; i++) {
            result[i] = input[i].trim().split("\\s+");
        }

        return result;
    }
}

