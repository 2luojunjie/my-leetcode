package huisu.leetcode46;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Permute
 * Package: huisu.leetcode46
 *
 * @author: 罗骏杰
 * @create: 2025-09-16 18:20
 * @Description:
 */
public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int[] used = new int[nums.length];
        backtracking(temp, res, used, nums);
        return res;
    }

    public static void backtracking(List<Integer> temp, List<List<Integer>> res, int[] used, int[] nums){

        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i] == 1){
                continue;
            }
            temp.add(nums[i]);
            used[i] = 1;
            backtracking(temp, res, used, nums);
            used[i] = 0;
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
    }
}