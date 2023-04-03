package org.example.segmented.display;

public class SegmentedJMatcher extends AbstractSegmentedSymbolMatcher{
    public SegmentedJMatcher(char[][] letterInSegmentedForm) {
        super(letterInSegmentedForm);
    }

    @Override
    protected int getNumberOfNeededHorizontalSegments() {
        return 1;
    }

    @Override
    protected int getNumberOfNeededVerticalSegments() {
        return 3;
    }

    @Override
    protected int getNumberOfNeededDiagonalSegments() {
        return 0;
    }

    @Override
    protected double additionalSimilarityFactor() {
        return hasVerticalSegment(1, 0) ? 0 : 100;
    }

    @Override
    public char getMatchersSymbol() {
        return 'J';
    }
}
