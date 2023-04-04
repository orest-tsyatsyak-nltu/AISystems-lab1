package org.example.segmented.display;

public class SegmentedOMatcher extends AbstractSegmentedSymbolMatcher{
    public SegmentedOMatcher(char[][] letterInSegmentedForm) {
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
    protected double additionalSimilarityFactor() {
        return rowHasHorizontalSegment(8) && !rowHasHorizontalSegment(4) ? 100 : 0;
    }


    @Override
    public char getMatchersSymbol() {
        return 'O';
    }
}
