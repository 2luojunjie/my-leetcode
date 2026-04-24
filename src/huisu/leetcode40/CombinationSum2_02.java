package huisu.leetcode40;

import java.util.*;

/**
 * ClassName: CombinationSum2_02
 * Package: huisu.leetcode40
 *
 * @author: 罗骏杰
 * @create: 2025-08-11 16:00
 * @Description:
 */

class Solution02 {
    //组合不能重复，candidates中的数字只能使用一次
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> temp  = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        Arrays.sort(candidates);
        // boolean[] used = new boolean[candidates.length];
        backtracking(candidates, target, temp, result, sum, 0);
        return result;
    }

    /**
     使用used标记
     */
    public void backtracking(int[] candidates, int target, LinkedList<Integer> temp, List<List<Integer>> result, int sum, int start){

        if(sum > target) return;

        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i < candidates.length && candidates[i] + sum <= target; i++){
            //使用start去重
            if(i != start && candidates[i] == candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            sum += candidates[i];
            // used[i] = true;
            backtracking(candidates, target, temp, result, sum, i+1);
            temp.removeLast();
            sum -= candidates[i];
            // used[i] = false;
        }
    }
}


public class CombinationSum2_02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution02 solution = new Solution02();
        String[] parts = scanner.nextLine().trim().split("\\s+");
        // 处理空输入
        if (parts.length == 1 && parts[0].isEmpty()) {
            parts = new String[0];
        }

        int[] array = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i]);
        }

        int target;

        target = scanner.nextInt();

        List<List<Integer>> result = solution.combinationSum2(array, target);
        System.out.println(result);
        scanner.close();
    }
}