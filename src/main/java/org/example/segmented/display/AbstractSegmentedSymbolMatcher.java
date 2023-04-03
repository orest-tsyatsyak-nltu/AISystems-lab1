package org.example.segmented.display;

import java.util.Arrays;

public abstract class AbstractSegmentedSymbolMatcher {

    public static final int NUMBER_OF_COLUMNS_IN_NINE_SEGMENT_DISPLAY = 5;

    public static final int NUMBER_OF_ROWS_IN_NINE_SEGMENT_DISPLAY = 9;

    public static final char SEGMENT_PIECE_ACTIVE_CHARACTER = '1';

    public static final int NUMBER_OF_ELEMENTS_IN_SEGMENT = 3;

    protected final char[][] letterInSegmentedForm;

    protected final int numberOfHorizontalSegments;

    protected final int numberOfVerticalSegments;

    protected final int numberOfDiagonalSegments;

    protected final double similarityPercentage;

    protected AbstractSegmentedSymbolMatcher(char[][] letterInSegmentedForm) {
        if (letterInSegmentedForm.length != NUMBER_OF_ROWS_IN_NINE_SEGMENT_DISPLAY) {
            throw new IllegalArgumentException("Number of rows must be equal to " + NUMBER_OF_ROWS_IN_NINE_SEGMENT_DISPLAY);
        }
        if (letterInSegmentedForm[0].length != NUMBER_OF_COLUMNS_IN_NINE_SEGMENT_DISPLAY) {
            throw new IllegalArgumentException("Number of cols must be equal to " + NUMBER_OF_COLUMNS_IN_NINE_SEGMENT_DISPLAY);
        }
        this.letterInSegmentedForm = letterInSegmentedForm;
        numberOfHorizontalSegments = countNumberOfHorizontalSegments();
        numberOfVerticalSegments = countNumberOfVerticalSegments();
        numberOfDiagonalSegments = countNumberOfDiagonalSegments();
        similarityPercentage = calculateSimilarityPercentage();
    }

    protected int countNumberOfHorizontalSegments() {
        final int VERTICAL_STEP_TO_NEXT_HORIZONTAL_LINE = 4;
        int horizontalSegmentsCount = 0;
        for (int rowI = 0; rowI < letterInSegmentedForm.length; rowI += VERTICAL_STEP_TO_NEXT_HORIZONTAL_LINE) {
            if (rowHasHorizontalSegment(rowI)) {
                horizontalSegmentsCount++;
            }
        }
        return horizontalSegmentsCount;
    }

    protected boolean rowHasHorizontalSegment(int rowI) {
        final int START_POSITION_OF_HORIZONTAL_SEGMENT = 1;
        int foundElementsOfSegment = 0;
        for (int colI = START_POSITION_OF_HORIZONTAL_SEGMENT; colI < letterInSegmentedForm[rowI].length; colI++) {
            if (letterInSegmentedForm[rowI][colI] == SEGMENT_PIECE_ACTIVE_CHARACTER) {
                foundElementsOfSegment++;
            }
        }
        return foundElementsOfSegment >= NUMBER_OF_ELEMENTS_IN_SEGMENT;
    }

    protected int countNumberOfVerticalSegments() {
        final int HORIZONTAL_STEP_TO_NEXT_VERTICAL_SEGMENT = 4;
        int verticalSegments = 0;
        for (int colI = 0; colI < letterInSegmentedForm[0].length;
             colI += HORIZONTAL_STEP_TO_NEXT_VERTICAL_SEGMENT) {
            verticalSegments += countVerticalSegmentsInColumn(colI);
        }
        return verticalSegments;
    }

    protected int countVerticalSegmentsInColumn(int colI) {
        final int START_POSITION_OF_VERTICAL_SEGMENT = 1;
        final int STEP_TO_NEXT_VERTICAL_SEGMENT_IN_SAME_COLUMN = 4;
        int verticalSegmentsCount = 0;
        for (int rowI = START_POSITION_OF_VERTICAL_SEGMENT; rowI < letterInSegmentedForm.length;
             rowI += STEP_TO_NEXT_VERTICAL_SEGMENT_IN_SAME_COLUMN) {
            if (hasVerticalSegment(rowI, colI)) {
                verticalSegmentsCount++;
            }
        }
        return verticalSegmentsCount;
    }

    protected boolean hasVerticalSegment(int rowIStartPosition, int colI) {
        int foundElementsOfSegment = 0;
        for (int rowI = rowIStartPosition; rowI < rowIStartPosition + NUMBER_OF_ELEMENTS_IN_SEGMENT; rowI++) {
            if (letterInSegmentedForm[rowI][colI] == SEGMENT_PIECE_ACTIVE_CHARACTER) {
                foundElementsOfSegment++;
            }
        }
        return foundElementsOfSegment >= NUMBER_OF_ELEMENTS_IN_SEGMENT;
    }

    protected int countNumberOfDiagonalSegments() {
        final int START_ROW_POSITION_FOR_DIAGONAL = 1;
        final int STEP_TO_NEXT_ROW_START_POSITION_FOR_DIAGONAL = 4;
        int diagonalSegmentsCount = 0;
        for (int rowI = START_ROW_POSITION_FOR_DIAGONAL; rowI < letterInSegmentedForm.length;
             rowI += STEP_TO_NEXT_ROW_START_POSITION_FOR_DIAGONAL) {
            if (diagonalHasSegment(rowI)) {
                diagonalSegmentsCount++;
            }
        }
        return diagonalSegmentsCount;
    }

    protected boolean diagonalHasSegment(int rowIStarter) {
        final int START_POSITION_FOR_COLUMN_IN_DIAGONAL = 3;
        int foundElementsInSegment = 0;
        for (int colI = START_POSITION_FOR_COLUMN_IN_DIAGONAL, rowI = rowIStarter;
             colI > 0 && rowI < letterInSegmentedForm.length; colI--, rowI++) {
            if (letterInSegmentedForm[rowI][colI] == SEGMENT_PIECE_ACTIVE_CHARACTER) {
                foundElementsInSegment++;
            }
        }
        return foundElementsInSegment >= NUMBER_OF_ELEMENTS_IN_SEGMENT;
    }

    protected abstract int getNumberOfNeededHorizontalSegments();

    protected abstract int getNumberOfNeededVerticalSegments();

    protected abstract int getNumberOfNeededDiagonalSegments();

    protected abstract char getMatchersSymbol();

    protected double additionalSimilarityFactor() {
        final int FULLY_SIMILAR_BY_DEFAULT = 100;
        return FULLY_SIMILAR_BY_DEFAULT;
    }

    protected double calculateSimilarityPercentage(){
        double similarityPercentForHorizontalSegments = findSimilarityInPercent(
                numberOfHorizontalSegments, getNumberOfNeededHorizontalSegments()
        );
        double similarityPercentForVerticalSegments = findSimilarityInPercent(
                numberOfVerticalSegments, getNumberOfNeededVerticalSegments()
        );
        double similarityPercentForDiagonalSegments = findSimilarityInPercent(
                numberOfDiagonalSegments, getNumberOfNeededDiagonalSegments()
        );
        return averageValue(similarityPercentForHorizontalSegments, similarityPercentForVerticalSegments,
                similarityPercentForDiagonalSegments, additionalSimilarityFactor());
    }

    private double findSimilarityInPercent(int number, int numberToBeSimilarTo) {
        if (numberToBeSimilarTo == 0) {
            if (number == 0) {
                return 100;
            } else {
                return 0;
            }
        }
        return (1 - (double) Math.abs(numberToBeSimilarTo - number) / numberToBeSimilarTo) * 100;
    }

    private double averageValue(double... numbers){
        return Arrays.stream(numbers).average().orElse(0);
    }

    public final double getSimilarityPercentage() {
        return similarityPercentage;
    }

    @Override
    public String toString() {
        return "Given segmented character is similar to %s on %s".formatted(getMatchersSymbol(), similarityPercentage);
    }
}
