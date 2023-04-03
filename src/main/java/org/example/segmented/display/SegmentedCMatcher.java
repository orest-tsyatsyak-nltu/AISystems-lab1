package org.example.segmented.display;

public class SegmentedCMatcher extends AbstractSegmentedSymbolMatcher{

    public SegmentedCMatcher(char[][] letterInSegmentedForm) {
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
    public char getMatchersSymbol() {
        return 'C';
    }

    @Override
    protected double additionalSimilarityFactor() {
        return rowHasHorizontalSegment(4) ? 0 : 100;
    }
}
