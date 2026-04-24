package huisu.leetcode216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: CombinationSum3
 * Package: huisu.leetcode216
 *
 * @author: 罗骏杰
 * @create: 2025-08-07 16:28
 * @Description:
 */

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtracking(n, k, path, result, 0, 1);
        return result;
    }

    /**
     *
     * @param targetSum 目标和
     * @param k k个数字相加
     * @param path 存放组合
     * @param result 存放结果
     * @param sum path里面的组合相加的和
     * @param startIndex 起始索引
     */
    public void backtracking(int targetSum, int k, LinkedList<Integer> path, List<List<Integer>> result, int sum, int startIndex){

        // 剪枝
        if(sum > targetSum || path.size() > k){
            return;
        }
        if(path.size() == k){
            if(sum == targetSum){
                result.add(new ArrayList<>(path));
                return;
            }
        }

        for(int i = startIndex; i <= 9 - (k - path.size()) + 1; i++){
            path.add(i);
            sum += i;
            if (sum > targetSum) { // 剪枝操作
                sum -= i; // 剪枝之前先把回溯做了
                path.removeLast(); // 剪枝之前先把回溯做了
                return;
            }
            backtracking(targetSum, k, path, result, sum, i+1);
            //回溯
            path.removeLast();
            sum -= i;
        }
    }
}

public class CombinationSum3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int k;
        int n;
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        List<List<Integer>> result = solution.combinationSum3(k, n);
        System.out.println(result);
    }
}