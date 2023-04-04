package org.example.segmented.display;

public class Segmented8Matcher extends AbstractSegmentedSymbolMatcher{
    public Segmented8Matcher(char[][] letterInSegmentedForm) {
        super(letterInSegmentedForm);
    }

    @Override
    protected int getNumberOfNeededHorizontalSegments() {
        return 3;
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
        return rowHasHorizontalSegment(8) ? 100 : 0;
    }

    @Override
    public char getMatchersSymbol() {
        return '8';
    }
}
