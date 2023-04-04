package org.example;

import org.example.segmented.display.AbstractSegmentedSymbolMatcher;
import org.example.segmented.display.Segmented3Matcher;
import org.example.segmented.display.Segmented8Matcher;
import org.example.segmented.display.SegmentedHMatcher;
import org.example.segmented.display.SegmentedOMatcher;
import org.example.segmented.file.SegmentedCharacterFileReader;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
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
                    new Segmented3Matcher(characterInSegmentedFormat),
                    new SegmentedHMatcher(characterInSegmentedFormat),
                    new SegmentedOMatcher(characterInSegmentedFormat),
                    new Segmented8Matcher(characterInSegmentedFormat)
            );
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }

    private static void findTheLeastSimilarAndPrintIt(AbstractSegmentedSymbolMatcher... matchers) {
        AbstractSegmentedSymbolMatcher closestSimilar = Arrays.stream(matchers)
                .peek(App::printSimilarityPercent)
                .max(Comparator.comparingDouble(AbstractSegmentedSymbolMatcher::getSimilarityPercentage)).get();
        AbstractSegmentedSymbolMatcher leastSimilar = Arrays.stream(matchers)
                .min(Comparator.comparingDouble(AbstractSegmentedSymbolMatcher::getSimilarityPercentage)).get();
        System.out.print(ANSI_MAGENTA);
        System.out.println("\n" +
                           "The closest similarity percentage to given symbol has %s %s".formatted(
                                   closestSimilar.getMatchersSymbol(),
                                   closestSimilar.getSimilarityPercentage()
                           ) + ANSI_RESET);
        System.out.print(ANSI_RED);
        System.out.println("\n" +
                           "The least similarity percentage to given symbol has %s %s".formatted(
                                   leastSimilar.getMatchersSymbol(),
                                   leastSimilar.getSimilarityPercentage()
                           ) + ANSI_RESET);
    }

    private static void printSimilarityPercent(AbstractSegmentedSymbolMatcher segmentedSymbolMatcher) {
        if (segmentedSymbolMatcher.getSimilarityPercentage() == 100) {
            System.out.print(ANSI_MAGENTA);
        }
        System.out.println(segmentedSymbolMatcher + ANSI_RESET);
    }
}
