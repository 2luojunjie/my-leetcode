package erchashu.leetcode1047;

import java.util.Stack;

/**
 * ClassName: LeetCode1047
 * Package: leetcode1047
 *
 * @author: 罗骏杰
 * @create: 2025-07-25 10:33
 * @Description: 删除字符串中的所有相邻重复项
 */
public class LeetCode1047 {
    public static String removeDuplicates(String s) {
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(str[0]);
        for (int i = 1; i < str.length; i++) {
            char c = str[i];
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        //从栈取出字符构建字符串
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}