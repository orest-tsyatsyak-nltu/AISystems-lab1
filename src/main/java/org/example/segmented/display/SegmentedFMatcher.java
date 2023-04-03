package org.example.segmented.display;

public class SegmentedFMatcher extends AbstractSegmentedSymbolMatcher{
    public SegmentedFMatcher(char[][] letterInSegmentedForm) {
        super(letterInSegmentedForm);
    }

    @Override
    protected int getNumberOfNeededHorizontalSegments() {
        return 2;
    }

    @Override
    protected int getNumberOfNeededVerticalSegments() {
        return 2;
    }

    @Override
    protected int getNumberOfNeededDiagonalSegments() {
        return 0;
    }

    @Override
    protected double additionalSimilarityFactor() {
        return rowHasHorizontalSegment(4) ? 100 : 0;
    }

    @Override
    protected char getMatchersSymbol() {
        return 'F';
    }
}
