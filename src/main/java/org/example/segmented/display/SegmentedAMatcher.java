package org.example.segmented.display;

public class SegmentedAMatcher extends AbstractSegmentedSymbolMatcher {

    public SegmentedAMatcher(char[][] letterInSegmentedForm) {
        super(letterInSegmentedForm);
    }

    @Override
    protected int getNumberOfNeededHorizontalSegments() {
        return 2;
    }

    @Override
    protected int getNumberOfNeededVerticalSegments() {
        return 4;
    }

    @Override
    protected int getNumberOfNeededDiagonalSegments() {
        return 0;
    }

    @Override
    protected char getMatchersSymbol() {
        return 'A';
    }

    @Override
    protected double additionalSimilarityFactor() {
        boolean hasBottomHorizontalSegment = rowHasHorizontalSegment(8);
        if(hasBottomHorizontalSegment){
            return 0;
        }
        return 100;
    }
}
