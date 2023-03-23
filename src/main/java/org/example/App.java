package org.example;

import org.example.segmented.display.ASegmentedSymbolMatcher;
import org.example.segmented.display.CSegmentedSymbolMatcher;

public class App {
    public static void main(String[] args) {
        char[][] AInSegmentFormat = {
                {'0', '1', '1', '1', '0'},
                {'1', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '1'},
                {'0', '1', '1', '1', '0'},
                {'1', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '1'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new ASegmentedSymbolMatcher(AInSegmentFormat).getSimilarityPercentage());
        char[][] nineInSegmentFormat = {
                {'0', '1', '1', '1', '0'},
                {'1', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '1'},
                {'1', '0', '0', '0', '1'},
                {'0', '1', '1', '1', '0'},
                {'0', '0', '0', '0', '1'},
                {'0', '0', '0', '0', '1'},
                {'0', '0', '0', '0', '1'},
                {'0', '1', '1', '1', '0'}
        };
        System.out.println(new ASegmentedSymbolMatcher(nineInSegmentFormat).getSimilarityPercentage());
        char[][] CInSegmentFormat = {
                {'0', '1', '1', '1', '0'},
                {'1', '0', '0', '0', '0'},
                {'1', '0', '0', '0', '0'},
                {'1', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '0', '0', '0'},
                {'1', '0', '0', '0', '0'},
                {'1', '0', '0', '0', '0'},
                {'0', '1', '1', '1', '0'}
        };
        System.out.println(new CSegmentedSymbolMatcher(CInSegmentFormat).getSimilarityPercentage());
        char[][] FInSegmentFormat = {
                {'0', '1', '1', '1', '0'},
                {'1', '0', '0', '0', '0'},
                {'1', '0', '0', '0', '0'},
                {'1', '0', '0', '0', '0'},
                {'0', '1', '1', '1', '0'},
                {'1', '0', '0', '0', '0'},
                {'1', '0', '0', '0', '0'},
                {'1', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(new CSegmentedSymbolMatcher(FInSegmentFormat).getSimilarityPercentage());
    }
}
