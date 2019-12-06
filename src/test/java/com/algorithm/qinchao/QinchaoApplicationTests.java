package com.algorithm.qinchao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QinchaoApplicationTests {

    @Test
    public void contextLoads() {

    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(null==s||s.length()==0){
            return 0;
        }
        int result = 0;
        Set<Character> set = new HashSet();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            int temp = 0;
            char ch = chars[i];
            if (set.contains(ch)) {
                if (temp > result) {
                    result = temp;
                    temp = 0;
                    set.clear();
                }
            } else {
                set.add(ch);
                temp++;
            }
        }
        return result;
    }
}
