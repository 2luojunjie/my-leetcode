package hot100.lc209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;

/**
 * ClassName: Main
 * Package: hot100.lc209
 * Description: 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * @Author: Luojunjie
 * @Create 2026/5/2 21:42
 * Version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(line == null || line.trim().isEmpty()) return;
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        line = br.readLine();
        st = new StringTokenizer(line);
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int minLen = minSubArrayLen(nums, target);

        System.out.println(minLen);

    }

    public static int minSubArrayLen(int[] nums, int target){
        int minLen = MAX_VALUE;
        int start = 0;//窗口左边界
        int sum = 0;

        for(int end = 0; end < nums.length; end++){
            sum += nums[end];

            while(sum >= target){
                //更新当前找到的最小长度
                minLen = Math.min(minLen, end -start + 1);

                sum -= nums[start];//窗口右移
                start++;

            }
        }

        return minLen == MAX_VALUE ? 0 : minLen ;
    }
}
