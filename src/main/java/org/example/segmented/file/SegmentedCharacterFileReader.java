package org.example.segmented.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.example.segmented.display.AbstractSegmentedSymbolMatcher.NUMBER_OF_ROWS_IN_NINE_SEGMENT_DISPLAY;

public class SegmentedCharacterFileReader {

    private final String pathToFile;

    public SegmentedCharacterFileReader(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public char[][] readSegmentedCharacter(){
        try(Scanner scanner = new Scanner(new File(pathToFile))){
            int rowIterator = 0;
            char[][] segmentedCharacter = new char[NUMBER_OF_ROWS_IN_NINE_SEGMENT_DISPLAY][];
            while(rowIterator < NUMBER_OF_ROWS_IN_NINE_SEGMENT_DISPLAY){
                segmentedCharacter[rowIterator] = scanner.nextLine().toCharArray();
                rowIterator++;
            }
            return segmentedCharacter;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
