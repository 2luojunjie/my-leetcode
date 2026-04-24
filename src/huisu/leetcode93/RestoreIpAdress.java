package huisu.leetcode93;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: RestoreIpAdress
 * Package: huisu.leetcode93
 *
 * @author: 罗骏杰
 * @create: 2025-08-12 10:58
 * @Description: 复原IP地址
 */

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtrack(result, s, temp, 0);
        return result;
    }

    public void backtrack(List<String> result, String s, List<String> temp, int start){

        // 分到形如["255.255.11.135"]，有四个组成
        if(temp.size() == 4){
            if(start == s.length()){
                //要分完全部的长度
                result.add(String.join(".", temp));
            }
            return;
        }

        // 每个part最多只有三位数
        for(int len = 1; len <= 3; len++){
            if(start + len > s.length()) break;

            String part = s.substring(start, start+len);
            if(isValid(part) == true){
                temp.add(part);
                backtrack(result, s, temp, start + len);
                temp.remove(temp.size() - 1);
            }
        }
    }

    // 判断分割出的部分是否满足构成有效Ip地址的条件
    public boolean isValid(String s){
        if(s.length() > 1 && s.charAt(0) == '0'){
            return false;
        }
        int value = Integer.parseInt(s);
        return value >= 0 && value <= 255;
    }
}

public class RestoreIpAdress {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "10102
        String s = "25525511135";
        List<String> validIp = solution.restoreIpAddresses(s);
        System.out.println(validIp);
    }
}