package org.example.segmented.display;

public class SegmentedHMatcher extends AbstractSegmentedSymbolMatcher{
    public SegmentedHMatcher(char[][] letterInSegmentedForm) {
        super(letterInSegmentedForm);
    }

    @Override
    protected int getNumberOfNeededHorizontalSegments() {
        return 1;
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
    protected double additionalSimilarityFactor() {
        return rowHasHorizontalSegment(8) ? 0 : 100;
    }


    @Override
    public char getMatchersSymbol() {
        return 'H';
    }
}
