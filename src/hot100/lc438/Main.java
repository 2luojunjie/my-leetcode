package hot100.lc438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: Main
 * Package: hot100.lc438
 * Description:
 *
 * @Author: Luojunjie
 * @Create 2026/4/25 17:40
 * Version 1.0
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next();
            String p = scanner.next();

            List<Integer> res = findAnagrams(s, p);
            System.out.println(res);
        }
        scanner.close();
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();

        if(sLen < pLen) return res;

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for(int i = 0; i < pLen; i++){
            pCount[p.charAt(i) - 'a']++;
        }
        // 开始滑动窗口，固定窗口，长度为 p 的长度
        for(int i = 0; i < sLen; i++){
            sCount[s.charAt(i) - 'a']++;

            // 左侧老字符移出窗口（当遍历索引 >= 窗口长度时触发）
            if(i >= pLen){
                sCount[s.charAt(i - pLen)-'a']--;
            }
            // 判断当前窗口是否与 p 匹配（确保窗口已经达到了 p 的长度）
            if(i >= pLen - 1){
                if(Arrays.equals(sCount, pCount)){
                    //窗口左边界为子串的起始索引
                    res.add(i - pLen + 1);
                }
            }
        }
        return res;
    }
}
