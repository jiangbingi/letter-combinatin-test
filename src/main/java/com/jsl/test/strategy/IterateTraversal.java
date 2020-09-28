package com.jsl.test.strategy;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 迭代策略
 */
public class IterateTraversal extends BaseTraversalStrategy {

    public IterateTraversal(Map<Integer, String> mapping){
        this.mapping = mapping;
    }

    @Override
    public void traversal(String[] digits, List<String> resultList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        for (int i = 0; i < digits.length; i++) {
            String digit = digits[i];
            final String letterStr = mapping.get(Integer.valueOf(digit));
            if ("".equals(letterStr))
                continue;
            for (int j = 0, queueSize = queue.size(); j < queueSize; j++) {
                final String lastLetter = queue.poll();
                for (int k = 0; k < letterStr.length(); k++){
                    queue.offer(lastLetter + letterStr.charAt(k));
                }
            }
        }
        resultList.addAll(queue);
    }
}
