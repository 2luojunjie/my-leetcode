package huisu.leetcode131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Partition
 * Package: huisu.leetcode131
 *
 * @author: 罗骏杰
 * @create: 2025-08-11 18:28
 * @Description: 分割回文串
 */

class Solution {
    public List<List<String>> partition(String s) {
        LinkedList<String> temp = new LinkedList<>();
        List<List<String>> result = new ArrayList<>();
        // StringBuilder sb = new StringBuilder();
        backtracking(s, 0, temp, result);
        return result;
    }

    public void backtracking(String s, int start, LinkedList<String> temp, List<List<String>> result){

        if(start == s.length()){
            result.add(new LinkedList<>(temp));
            return;
        }

        for(int end = start + 1; end <= s.length(); end++){
            String substring = s.substring(start, end);
            if(isParlindrome(substring)){
                temp.add(substring);
                backtracking(s, end, temp, result);
                temp.removeLast();
            }
        }
    }



    public boolean isParlindrome(String str){
        if(str == "") return false;
        int left = 0;
        int right = str.length() -1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

public class Partition {
    public static void main(String[] args) {
        String str = "aab";
        Solution solution = new Solution();
        List<List<String>> result = solution.partition(str);
        System.out.println(result);
    }
}