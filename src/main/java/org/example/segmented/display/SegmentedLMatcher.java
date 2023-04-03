package org.example.segmented.display;

public class SegmentedLMatcher extends AbstractSegmentedSymbolMatcher{
    public SegmentedLMatcher(char[][] letterInSegmentedForm) {
        super(letterInSegmentedForm);
    }

    @Override
    protected int getNumberOfNeededHorizontalSegments() {
        return 1;
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
        return countVerticalSegmentsInColumn(4) == 0 ? 100 : 0;
    }

    @Override
    public char getMatchersSymbol() {
        return 'L';
    }
}
