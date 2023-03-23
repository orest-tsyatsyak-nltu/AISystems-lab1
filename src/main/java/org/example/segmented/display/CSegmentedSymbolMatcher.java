package org.example.segmented.display;

public class CSegmentedSymbolMatcher extends AbstractSegmentedSymbolMatcher{

    public static final int NUMBER_OF_HORIZONTAL_SEGMENTS = 2;

    public static final int NUMBER_OF_VERTICAL_SEGMENTS = 2;

    public CSegmentedSymbolMatcher(char[][] letterInSegmentedForm) {
        super(letterInSegmentedForm);
    }

    @Override
    protected int getNumberOfNeededHorizontalSegments() {
        return NUMBER_OF_HORIZONTAL_SEGMENTS;
    }

    @Override
    protected int getNumberOfNeededVerticalSegments() {
        return NUMBER_OF_VERTICAL_SEGMENTS;
    }

    @Override
    protected int getNumberOfNeededDiagonalSegments() {
        return 0;
    }

    @Override
    protected double additionalSimilarityFactor() {
        boolean hasMiddleHorizontalSegment = rowHasHorizontalSegment(4);
        if(hasMiddleHorizontalSegment){
            return 0;
        }
        return 100;
    }
}
