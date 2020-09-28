package com.jsl.test.strategy;

import java.util.List;
import java.util.Map;

/**
 * 递归遍历
 */
public class RecursiveTraversal extends BaseTraversalStrategy {

    public RecursiveTraversal(Map<Integer, String> mapping){
        this.mapping = mapping;
    }

    @Override
    public void traversal(String[] digits, List<String> resultList) {
        int level = 0;
        String path = "";
        doRecurTraversal(level, path, digits, resultList);
    }

    public void doRecurTraversal(int level, String path, String[] digits, List<String> resultList) {
        if ( level == digits.length ) {
            resultList.add(path);
            return;
        }
        final String currentLetterStr = mapping.get(Integer.valueOf(digits[level]));
        if ("".equals(currentLetterStr)){
            doRecurTraversal(level + 1,  path, digits, resultList);
        }
        for (int i = 0; i < currentLetterStr.length(); i++){
            final char letter = currentLetterStr.charAt(i);
            final String nextPath = path + letter;
            doRecurTraversal(level + 1,  nextPath, digits, resultList);
        }
    }



}
