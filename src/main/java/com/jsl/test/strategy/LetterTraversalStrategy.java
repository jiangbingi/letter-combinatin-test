package com.jsl.test.strategy;

import java.util.List;

/**
 * 遍历策略：目前有递归和迭代两种策略
 */
public interface LetterTraversalStrategy {
    /**
     * 遍历数字串得到所有表示的字母组合
     * @param digits 输入数字串
     * @param resultList 所有组合结果
     */
    void traversal(String[] digits, List<String> resultList);
}
