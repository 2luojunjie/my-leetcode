package hot100.lc76;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ClassName: Main
 * Package: hot100.lc76
 * Description: 给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，
 * 使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，返回空字符串 ""。
 * 测试用例保证答案唯一。
 *     示例 1：
 *      输入：s = "ADOBECODEBANC", t = "ABC"
 *      输出："BANC"
 *      解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * @Author: Luojunjie
 * @Create 2026/5/3 15:47
 * Version 1.0
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        String result = minWindow(s, t);

        System.out.print(result);
    }

    public static String minWindow(String s, String t){
        if(s== null || t== null || s.isEmpty() || t.isEmpty() || s.length() < t.length() ) return "";

        // 记录t中每个字符的需求量
        int[] need = new int[128];
        for(int i = 0; i < t.length(); i++){
            need[t.charAt(i)]++;
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int needCount = t.length();
        int start = 0; //记录最小窗口的起始位置
        //窗口滑动
        while(right < s.length()){
            char c = s.charAt(right);
            if(need[c] > 0){ //说明该字符是我们需要的
                needCount--;
            }
            need[c]--;
            right++;
            while(needCount == 0){ // 该窗口包含了需要的全部字符
                if(minLen > right - left){
                    minLen = right - left;
                    start = left;
                }

                //左窗口右移
                char d = s.charAt(left);
                left++;
                need[d]++;
                if(need[d] > 0){ //说明该字符是我们需要的
                    needCount++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
