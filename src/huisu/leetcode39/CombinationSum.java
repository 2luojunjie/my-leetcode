package huisu.leetcode39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: CombinationSum
 * Package: huisu.leetcode39
 *
 * @author: 罗骏杰
 * @create: 2025-08-07 20:56
 * @Description:
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> temp  = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        backtracking(candidates, target, temp, result, sum, 0);
        return result;
    }

    public void backtracking(int[] candidates, int target, LinkedList<Integer> temp, List<List<Integer>> result, int sum, int start){

        if(sum > target) return;

        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            temp.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, temp, result, sum, i);
            temp.removeLast();
            sum -= candidates[i];
        }
    }
}

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates ={2,3,6,7};
        int target = 7;
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        System.out.println(result);
    }
}