package org.example;

import org.example.segmented.display.AbstractSegmentedSymbolMatcher;
import org.example.segmented.display.SegmentedAMatcher;
import org.example.segmented.display.SegmentedCMatcher;
import org.example.segmented.display.SegmentedFMatcher;
import org.example.segmented.display.SegmentedGMatcher;
import org.example.segmented.display.SegmentedHMatcher;
import org.example.segmented.display.SegmentedJMatcher;
import org.example.segmented.display.SegmentedLMatcher;
import org.example.segmented.display.SegmentedSMatcher;
import org.example.segmented.display.SegmentedUMatcher;
import org.example.segmented.display.SegmentedYMatcher;
import org.example.segmented.file.SegmentedCharacterFileReader;

import java.io.File;
import java.util.Scanner;

public class App {

    public static final String ANSI_MAGENTA = "\033[35m";
    public static final String ANSI_RESET = "\033[0m";

    public static final String ANSI_RED = "\033[31m";

    public static void main(String[] args) {
        String pathToFile;
        System.out.print("Enter filename with segmented letter: ");
        pathToFile = "letters" + File.separator + new Scanner(System.in).nextLine() + ".txt";
        SegmentedCharacterFileReader segmentedCharacterFileReader = new SegmentedCharacterFileReader(pathToFile);
        try {
            char[][] characterInSegmentedFormat = segmentedCharacterFileReader.readSegmentedCharacter();
            findTheLeastSimilarAndPrintIt(
                    new SegmentedAMatcher(characterInSegmentedFormat),
                    new SegmentedCMatcher(characterInSegmentedFormat),
                    new SegmentedGMatcher(characterInSegmentedFormat),
                    new SegmentedFMatcher(characterInSegmentedFormat),
                    new SegmentedJMatcher(characterInSegmentedFormat),
                    new SegmentedHMatcher(characterInSegmentedFormat),
                    new SegmentedLMatcher(characterInSegmentedFormat),
                    new SegmentedSMatcher(characterInSegmentedFormat),
                    new SegmentedUMatcher(characterInSegmentedFormat),
                    new SegmentedYMatcher(characterInSegmentedFormat)
            );
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }

    private static void findTheLeastSimilarAndPrintIt(AbstractSegmentedSymbolMatcher... matchers) {
        double leastSimilarPercent = 101;
        int leastSimilarIndex = 0;
        double closestSimilarPercent = -1;
        int closestSimilarIndex = 0;
        for (int i = 0; i < matchers.length; i++) {
            double similarityPercentage = matchers[i].getSimilarityPercentage();
            if (similarityPercentage < leastSimilarPercent) {
                leastSimilarPercent = similarityPercentage;
                leastSimilarIndex = i;
            }
            if(similarityPercentage > closestSimilarPercent){
                closestSimilarPercent = similarityPercentage;
                closestSimilarIndex = i;
            }
            printSimilarityPercent(matchers[i]);
        }
        System.out.print(ANSI_RED);
        AbstractSegmentedSymbolMatcher leastSimilarSymbol = matchers[leastSimilarIndex];
        System.out.println("\n" +
                           "The least similarity percentage to given symbol has %s %s".formatted(
                                   leastSimilarSymbol.getMatchersSymbol(),
                                   leastSimilarSymbol.getSimilarityPercentage()
                           ) + ANSI_RESET);
        System.out.print(ANSI_MAGENTA);
        AbstractSegmentedSymbolMatcher closestSimilarSymbol = matchers[closestSimilarIndex];
        System.out.println("\n" +
                           "The closest similarity percentage to given symbol has %s %s".formatted(
                                   closestSimilarSymbol.getMatchersSymbol(),
                                   closestSimilarSymbol.getSimilarityPercentage()
                           ) + ANSI_RESET);
    }

    private static void printSimilarityPercent(AbstractSegmentedSymbolMatcher segmentedSymbolMatcher) {
        if (segmentedSymbolMatcher.getSimilarityPercentage() == 100) {
            System.out.print(ANSI_MAGENTA);
        }
        System.out.println(segmentedSymbolMatcher + ANSI_RESET);
    }
}
