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

    public static void main(String[] args) {
        String pathToFile;
        System.out.print("Enter filename with segmented letter: ");
        pathToFile = "letters" + File.separator + new Scanner(System.in).nextLine() + ".txt";
        SegmentedCharacterFileReader segmentedCharacterFileReader = new SegmentedCharacterFileReader(pathToFile);
        try {
            char[][] characterInSegmentedFormat = segmentedCharacterFileReader.readSegmentedCharacter();
            printSimilarityPercent(new SegmentedAMatcher(characterInSegmentedFormat));
            printSimilarityPercent(new SegmentedCMatcher(characterInSegmentedFormat));
            printSimilarityPercent(new SegmentedGMatcher(characterInSegmentedFormat));
            printSimilarityPercent(new SegmentedFMatcher(characterInSegmentedFormat));
            printSimilarityPercent(new SegmentedJMatcher(characterInSegmentedFormat));
            printSimilarityPercent(new SegmentedHMatcher(characterInSegmentedFormat));
            printSimilarityPercent(new SegmentedLMatcher(characterInSegmentedFormat));
            printSimilarityPercent(new SegmentedSMatcher(characterInSegmentedFormat));
            printSimilarityPercent(new SegmentedUMatcher(characterInSegmentedFormat));
            printSimilarityPercent(new SegmentedYMatcher(characterInSegmentedFormat));
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }

    private static void printSimilarityPercent(AbstractSegmentedSymbolMatcher segmentedSymbolMatcher){
        if(segmentedSymbolMatcher.getSimilarityPercentage() == 100){
            System.out.print(ANSI_MAGENTA);
        }
        System.out.println(segmentedSymbolMatcher + ANSI_RESET);
    }
}
