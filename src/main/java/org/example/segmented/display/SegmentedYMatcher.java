package org.example.segmented.display;

public class SegmentedYMatcher extends AbstractSegmentedSymbolMatcher{
    public SegmentedYMatcher(char[][] letterInSegmentedForm) {
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
        return 1;
    }

    @Override
    protected char getMatchersSymbol() {
        return 'Y';
    }
}
