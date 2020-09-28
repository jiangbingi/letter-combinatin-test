package com.jsl.test;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SimpleLetterCombinationTest {

    private SimpleLetterCombination letterCombination;

    @Before
    public void setup(){
        letterCombination = new SimpleLetterCombination();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckDigitRangeWithEmpty(){
        String[] digits = null;
        letterCombination.checkDigit(digits);

        digits = new String[]{};
        letterCombination.checkDigit(digits);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckDigitRangeWithIllegalDigit(){
        String[] digits = new String[]{"1","2","*"};
        letterCombination.checkDigit(digits);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckDigitRangeWithLargeNumber(){
        String[] digits = new String[]{"1","2","100"};
        letterCombination.checkDigit(digits);
    }

    @Test
    public void testFindCombination(){
        // 正常两位数
        String[] digits = new String[]{"2","3"};
        List<String> combinationList = letterCombination.findCombination(digits);
        assert combinationList.size() == 9;

        // 正常三位数
        digits = new String[]{"2","3", "9"};
        combinationList = letterCombination.findCombination(digits);
        assert combinationList.size() == 36;

        // 包含特殊数字
        digits = new String[]{"2","3", "1"};
        combinationList = letterCombination.findCombination(digits);
        assert combinationList.size() == 9;

        // 包含特殊数字
        digits = new String[]{"2","3", "0"};
        combinationList = letterCombination.findCombination(digits);
        assert combinationList.size() == 9;

    }

}