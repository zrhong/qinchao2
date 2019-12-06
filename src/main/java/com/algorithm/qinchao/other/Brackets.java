package com.algorithm.qinchao.other;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/16 13:09
 * @description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Brackets {
    public static boolean isValid(String str) {
        if (StringUtils.isEmpty(str)) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack stack = new Stack();
        stack.push(str.charAt(0));
        if (map.containsKey(str.charAt(0))) {
            return false;
        }
        stack.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (map.containsKey(temp)) {
                if (stack.empty()) {
                    return false;
                }
                if (stack.peek().equals(map.get(temp))) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(temp);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
//        System.out.println("()" + Brackets.isValid("()"));
//        System.out.println("()[]{}" + Brackets.isValid("()[]{}"));
//        System.out.println("(]" + Brackets.isValid("(]"));
//        System.out.println("([)]" + Brackets.isValid("([)]"));
//        System.out.println("{[]}" + Brackets.isValid("{[]}"));
        System.out.println("[])" + Brackets.isValid("[])"));
    }

}
