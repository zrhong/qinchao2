package com.algorithm.qinchao.q14;

import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/2 14:15
 * @description 通过排序来确定是否异位字母单词  ，快排，NlogN
 */
public class EffectiveLetterEctopicBySort {
    public boolean isEffectiveLetterEctopic(String word1,String word2) {
        if (StringUtils.isEmpty(word1)) {
            return false;
        }
        char[] words1 = word1.toCharArray();
        char[] words2 = word2.toCharArray();
        Arrays.sort(words1);
        Arrays.sort(words2);
        if (Arrays.equals(words1, words2)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String word1 = "zhuruihong";
        String word2 = "ruihongzhu";
        EffectiveLetterEctopicBySort ectopicBySort = new EffectiveLetterEctopicBySort();
        System.out.println(ectopicBySort.isEffectiveLetterEctopic(word1, word2));

    }
}
