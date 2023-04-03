package org.example.segmented.display;

public class SegmentedGMatcher extends AbstractSegmentedSymbolMatcher{
    public SegmentedGMatcher(char[][] letterInSegmentedForm) {
        super(letterInSegmentedForm);
    }

    @Override
    protected int getNumberOfNeededHorizontalSegments() {
        return 3;
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
        return hasVerticalSegment(1, 4) ? 0 : 100;
    }

    @Override
    protected char getMatchersSymbol() {
        return 'G';
    }
}
