package huisu.leetcode17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: LetterCombinations
 * Package: huisu.leetcode17
 *
 * @author: 罗骏杰
 * @create: 2025-08-07 18:18
 * @Description:
 */

class Solution {
    public List<String> letterCombinations(String digits) {
        String[] numMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        backtracking(numMap, 0, digits, result, sb);
        return result;
    }

    public void backtracking(String[] numMap, int k, String digits, List<String> result, StringBuilder sb){
        if(digits.equals("")){
            return;
        }
        if(k == digits.length()){
            result.add(sb.toString());
            return;
        }
        String s = numMap[digits.charAt(k) - '0'];
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            backtracking(numMap, k+1, digits, result, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

public class LetterCombinations {
    public static void main(String[] args) {
        String digits;
        Scanner scanner = new Scanner(System.in);
        //这里输入的时候digits不用带""
        digits = scanner.nextLine();
        scanner.close();
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations(digits);
        System.out.println(result);
    }
}