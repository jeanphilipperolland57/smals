package com.bnp.pf.transformation.genesys.reader.service;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
class UtilTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void givenSystemOutRedirection_whenInvokePrintln_thenOutputCaptorSuccess() {
        System.out.print("Hello Baeldung Readers!!");

        Assert.assertEquals("Hello Baeldung Readers!!", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void firstNumber() {
        com.bnp.pf.transformation.genesys.reader.service.Util.firstNumber();
    }

    @Test
    void printWordsVertically() {
        List<String> sentences = Arrays.asList("I am the first sentence","This is the second","Third one");
        String[] myArray = new String[sentences.size()];
        sentences.toArray(myArray);
        com.bnp.pf.transformation.genesys.reader.service.Util.printWordsVertically(myArray);
        Assert.assertEquals("I           This        Third       \n" +
                "am          is          one         \n" +
                "the         the                     \n" +
                "first       second                  \n" +
                "sentence", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void BuzzTest() {
        com.bnp.pf.transformation.genesys.reader.service.Util.buzz();
    }

    @Test
    void wordCountTest() {
        com.bnp.pf.transformation.genesys.reader.service.Util.countingWords("this is");
    }

    @Test
    void removeConsecutiveDuplicatesTest() {
        String S1 = "aaab";
        System.out.print(com.bnp.pf.transformation.genesys.reader.service.Util.removeConsecutiveDuplicates(S1,2));
        Assert.assertEquals("ab", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void FiboTest() {
        //  Util.fibo(0);
        // Util.fibo(1);
        com.bnp.pf.transformation.genesys.reader.service.Util.fiboUntil(10);
        //  Util.fiboRecu(2);
    }
}