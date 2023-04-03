package org.example.segmented.display;

public class SegmentedUMatcher extends AbstractSegmentedSymbolMatcher{
    public SegmentedUMatcher(char[][] letterInSegmentedForm) {
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
        return rowHasHorizontalSegment(4) ? 0 : 100;
    }

    @Override
    protected char getMatchersSymbol() {
        return 'U';
    }
}
