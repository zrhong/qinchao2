package com.algorithm.qinchao.q14;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/2 14:28
 * @description
 */
public class EffectiveLetterEctopicByMap {
    public boolean isEffectiveLetterEctopic(String word1,String word2) {
        if (null == word1 || null == word2) {
            return false;
        }
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        map1 = getLetterCountMap(chars1);
        map2 = getLetterCountMap(chars2);
        return map1.equals(map2);


    }

    private Map<String, Integer> getLetterCountMap(char[] chars1) {
        Map<String, Integer> resultMap = new HashMap<>();
        for (int i = 0; i <chars1.length ; i++) {
            char temp = chars1[i];
            if (resultMap.containsKey(String.valueOf(temp))) {
                resultMap.replace(String.valueOf(temp), resultMap.get(String.valueOf(temp)) + 1);
            } else {
                resultMap.put(String.valueOf(temp), 1);
            }
        }
        return resultMap;
    }

    public static void main(String[] args) {
        String word1 = "zhuruihong";
        String word2 = "ruihongzhu";
        EffectiveLetterEctopicByMap ectopicBySort = new EffectiveLetterEctopicByMap();
        System.out.println(ectopicBySort.isEffectiveLetterEctopic(word1, word2));

    }
}
