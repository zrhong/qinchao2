package com.algorithm.qinchao;

import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/7 10:44
 * @description
 */
public class Test {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }




    public static int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet();
        char[] chars = s.toCharArray();
        int length = chars.length;
        int i = 0;
        int j = 0;
        int max = 0;
        for (; i < length && j < length; ) {
            char ch = chars[j];
            if (!set.contains(ch)) {
                set.add(ch);
                j++;
            } else {
                set.remove(chars[i]);
                i++;
            }
            max = Math.max(max, j - i);
        }
        return max;
//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0, i = 0, j = 0;
//        while (i < n && j < n) {
//            // try to extend the range [i, j]
//            if (!set.contains(s.charAt(j))){
//                set.add(s.charAt(j++));
//                ans = Math.max(ans, j - i);
//            }
//            else {
//                set.remove(s.charAt(i++));
//            }
//        }
//        return ans;

    }


}
