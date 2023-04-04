package org.example.segmented.display;

public class Segmented3Matcher extends AbstractSegmentedSymbolMatcher{

    public Segmented3Matcher(char[][] letterInSegmentedForm) {
        super(letterInSegmentedForm);
    }

    @Override
    protected int getNumberOfNeededHorizontalSegments() {
        return 2;
    }

    @Override
    protected int getNumberOfNeededVerticalSegments() {
        return 0;
    }

    @Override
    protected int getNumberOfNeededDiagonalSegments() {
        return 2;
    }

    @Override
    protected double additionalSimilarityFactor() {
        return rowHasHorizontalSegment(8) ? 0 : 100;
    }

    @Override
    public char getMatchersSymbol() {
        return '3';
    }
}
