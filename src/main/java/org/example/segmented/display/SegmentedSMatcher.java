package org.example.segmented.display;

public class SegmentedSMatcher extends AbstractSegmentedSymbolMatcher{
    public SegmentedSMatcher(char[][] letterInSegmentedForm) {
        super(letterInSegmentedForm);
    }

    @Override
    protected int getNumberOfNeededHorizontalSegments() {
        return 3;
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
        return hasVerticalSegment(5, 0) ? 0 : 100;
    }

    @Override
    protected char getMatchersSymbol() {
        return 'S';
    }
}
