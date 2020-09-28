package com.jsl.test.strategy;

import java.util.Map;

/**
 * 遍历策略基类
 */
public abstract class BaseTraversalStrategy implements LetterTraversalStrategy{

    // 一个数字所表示的字母串
    protected Map<Integer, String> mapping;
}
