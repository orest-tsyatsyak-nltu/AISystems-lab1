package org.example.segmented.display;

public class SegmentedEMatcher extends AbstractSegmentedSymbolMatcher{
    public SegmentedEMatcher(char[][] letterInSegmentedForm) {
        super(letterInSegmentedForm);
    }

    @Override
    protected int getNumberOfNeededHorizontalSegments() {
        return 2;
    }

    @Override
    protected int getNumberOfNeededVerticalSegments() {
        return 1;
    }

    @Override
    protected int getNumberOfNeededDiagonalSegments() {
        return 1;
    }

    @Override
    protected double additionalSimilarityFactor() {
        return rowHasHorizontalSegment(8) ? 100 : 0;
    }


    @Override
    public char getMatchersSymbol() {
        return 'E';
    }
}
