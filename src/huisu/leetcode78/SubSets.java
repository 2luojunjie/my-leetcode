package huisu.leetcode78;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SubSets
 * Package: huisu.leetcode78
 *
 * @author: 罗骏杰
 * @create: 2025-08-12 16:46
 * @Description:
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, temp, result, nums);
        return result;
    }

    public void backtrack(int start, List<Integer> temp, List<List<Integer>> result, int[] nums){

        // 每一个节点都要收集
        // 当start > nums.length时终止递归，返回。但是这里可以不用写终止条件，因为start > nums.length时本身for循环也结束了
        result.add(new ArrayList<>(temp));

        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(i+1, temp, result, nums);
            temp.remove(temp.size() - 1);
        }
    }
}

public class SubSets {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }
}