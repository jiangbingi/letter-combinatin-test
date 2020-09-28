package com.jsl.test;

import com.jsl.test.strategy.LetterTraversalStrategy;
import com.jsl.test.strategy.RecursiveTraversal;

public class SimpleLetterCombination extends BaseLetterCombination {

    protected boolean checkDigitRange(int value){
        return value >= 0 && value <= 9;
    }

    @Override
    protected void buildMapping(String[] digits) {}

    @Override
    protected LetterTraversalStrategy getLetterTraversalStrategy(String[] digits) {
        return new RecursiveTraversal(mapping);
    }

}
