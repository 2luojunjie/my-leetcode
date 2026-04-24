package dp.lc494目标和;

/**
 * ClassName: FindTargetSumWays
 * Package: dp.lc494目标和
 *
 * @author: 罗骏杰
 * @create: 2025-12-08 21:50
 * @Description:
 */

class Solution {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    public void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }
}


public class FindTargetSumWays {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;

        Solution solution = new Solution();
        int count = solution.findTargetSumWays(nums, target);
        System.out.println(count);
    }
}