package erchashu.leetcode1047;

import java.util.Stack;

/**
 * ClassName: LeetCode1047
 * Package: leetcode1047
 *
 * @author: 罗骏杰
 * @create: 2025-07-25 10:33
 * @Description:
 */
public class LeetCode1047_02 {
    public static String removeDuplicates(String s) {
        //模拟栈 双指针
        char[] str = s.toCharArray();
        int top = -1;
        for(int i = 0; i < str.length; i++){
            if(top == -1 || str[top] != str[i]){
                str[++top] = str[i];
            }else {
                top--;
            }
        }
        //从str数组，索引0开始，共top+1个字符构成字符串
        return new String(str, 0, top+1);
    }
}