package huisu.leetcode40;

import java.util.*;

/**
 * ClassName: CombinationSum2
 * Package: huisu.leetcode40
 *
 * @author: 罗骏杰
 * @create: 2025-08-10 17:19
 * @Description:
 */

//组合总和

class Solution {
    //组合不能重复，candidates中的数字只能使用一次
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> temp  = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtracking(candidates, target, temp, result, sum, 0, used);
        return result;
    }

    /**
     使用used标记
     */
    public void backtracking(int[] candidates, int target, LinkedList<Integer> temp, List<List<Integer>> result, int sum, int start, boolean[] used){

        if(sum > target) return;

        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i < candidates.length && candidates[i] + sum <= target; i++){
            //防止同一树层重复
            if(i > 0 && candidates[i] == candidates[i-1] && used[i-1] == false){
                continue;
            }
            temp.add(candidates[i]);
            sum += candidates[i];
            //使用used记录同一树枝上的元素是否已经使用过
            used[i] = true;
            backtracking(candidates, target, temp, result, sum, i+1, used);
            //回溯
            temp.removeLast();
            sum -= candidates[i];
            used[i] = false;
        }
    }
}


public class CombinationSum2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
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