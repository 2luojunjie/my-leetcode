package hot100.lc53;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc53
 * Description: 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组
 * （子数组最少包含一个元素），返回其最大和。子数组是数组中的一个连续部分
 *
 * @Author: Luojunjie
 * @Create 2026/5/5 15:25
 * Version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line == null || line.trim().isEmpty()) return;
        int n = Integer.parseInt(line.trim());
        int[] nums = new int[n];
        line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int result = maxSUbArray(nums);
        System.out.println(result);
    }

    public static int maxSUbArray(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        // 记录走到当前位置时，连续子数组的和
        int currentSum = 0;
        int maxSum = nums[0];
        for(int i = 0; i < nums.length;i++){
            // 贪心策略：如果前面的累加和大于 0，说明对当前元素有“增益”，那就加上
            if(currentSum > 0) {
                currentSum += nums[i];
            }else {
                //如果前面的累加和小于等于 0，说明是“累赘”，果断抛弃历史，从头开始
                currentSum = nums[i];
            }

            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
