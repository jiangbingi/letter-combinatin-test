package com.jsl.test;

import com.jsl.test.strategy.IterateTraversal;
import com.jsl.test.strategy.LetterTraversalStrategy;

public class ExtendLetterCombination extends BaseLetterCombination {

    @Override
    protected boolean checkDigitRange(int value) {
        return value >= 0 && value <= 99;
    }

    @Override
    protected void buildMapping(String[] digits) {
        for (String digit : digits) {
            int value = Integer.parseInt(digit);
            if (value > 9 && mapping.get(value) == null){
                int quotient = value / 10;
                int remainder = value % 10;
                mapping.put(value, mapping.get(quotient) + mapping.get(remainder));
            }
        }
    }

    @Override
    protected LetterTraversalStrategy getLetterTraversalStrategy(String[] digits) {
        return new IterateTraversal(mapping);
    }
}
