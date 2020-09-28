package com.jsl.test;

import com.jsl.test.strategy.LetterTraversalStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseLetterCombination {

    protected Map<Integer, String> mapping = new HashMap<Integer, String>(){
        {
            // 初始化默认映射关系
            put(0, "");
            put(1, "");
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "prqs");
            put(8, "tuv");
            put(9, "wxyz");
        }
    };

    /**
     * 检查输入内容是否纯数字，超出范围
     * @param digits 数字串
     */
    public void checkDigit(String[] digits) {
        if (digits == null || digits.length == 0) {
            throw new IllegalArgumentException("数字串为空");
        }
        for (int i = 0, digitsLength = digits.length; i < digitsLength; i++) {
            String digit = digits[i];
            try {
                int value = Integer.parseInt(digit);
                if (!checkDigitRange(value)) {
                    throw new IllegalArgumentException("下标" + i + "：数字范围有误");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("下标" + i + "：不是数字");
            }
        }
    }

    /**
     * 找到数字表示的所有字母组合
     * @param digits 数字串
     * @return 所有字母组合
     */
    public List<String> findCombination(String[] digits) {
        List<String> resultList = new ArrayList<>();
        // 1.校验数字合法性
        checkDigit(digits);
        // 2.构造映射关系
        buildMapping(digits);
        // 3.选择执行策略
        LetterTraversalStrategy traversalStrategy = getLetterTraversalStrategy(digits);
        // 4.执行遍历获取结果
        traversalStrategy.traversal(digits, resultList);
        return resultList;
    }

    /**
     * 由不同子类来确定校验范围
     */
    protected abstract boolean checkDigitRange(int value);

    /**
     * 由不同子类来构造映射关系
     */
    protected abstract void buildMapping(String[] digits);

    /**
     * 由不同子类来确定执行策略
     */
    protected abstract LetterTraversalStrategy getLetterTraversalStrategy(String[] digits);

}
