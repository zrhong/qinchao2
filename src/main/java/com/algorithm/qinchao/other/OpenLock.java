package com.algorithm.qinchao.other;

import java.util.*;

/**
 * @author zhuruihong
 * @version 1.0
 * @date 2019/10/16 17:02
 * @description
 */
public class OpenLock {
    public static int openLock(String[] deadends, String target) {
        //target的验证
        if (null == target || target.length() == 0) {
            return -1;
        }
        List<String> dead = Arrays.asList(deadends);
        String begin = "0000";
        //死锁中是否含有开始和target
        if (dead.contains(begin) || dead.contains(target)) {
            return -1;
        }
        int step = 0;
        Queue<String> queue = new LinkedList();
        queue.add(begin);
        Set<String> visted = new HashSet<>();
        visted.add(begin);
        while (!queue.isEmpty()) {
            //队列的数目会一直增加，所以需要先初始i，不能使用++的模式，要使用--
            for (int i = queue.size(); i > 0; i--) {
                String current = queue.poll();
                if (target.equals(current)) {
                    return step;
                }
                List<String> possibles = getNexts(current);
                for (String temp : possibles) {
                    if (!dead.contains(temp) && !visted.contains(temp)) {
                        queue.add(temp);
                        visted.add(temp);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    // 获得当前值转动一位可以转动到的所有情况
    private static List<String> getNexts(String cur) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            StringBuilder curBuilder = new StringBuilder(cur);
            char modChar = cur.charAt(i);
            curBuilder.setCharAt(i, modChar == '0' ? '9' : (char) (modChar - 1));
            list.add(curBuilder.toString());
            curBuilder.setCharAt(i, modChar == '9' ? '0' : (char) (modChar + 1));
            list.add(curBuilder.toString());
        }
        return list;
    }


    /**
     * 牛逼哄哄的
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock2(String[] deadends, String target) {
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        begin.add("0000");
        end.add(target);
        int level = 0;
        while (!begin.isEmpty() && !end.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String s : begin) {
                if (end.contains(s)) {
                    return level;
                }
                //这条路我已经走过了
                if (deads.contains(s)) {
                    continue;
                }
                deads.add(s);
                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < 4; i++) {
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
                    if (!deads.contains(s1)) {
                        temp.add(s1);
                    }
                    if (!deads.contains(s2)) {
                        temp.add(s2);
                    }
                }
            }
            level++;
            begin = end;
            end = temp;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadlines = {
                "0201", "0101", "0102", "1212", "2002"
        };
        String target = "0202";
        System.out.println(OpenLock.openLock(deadlines, target));
    }
}
