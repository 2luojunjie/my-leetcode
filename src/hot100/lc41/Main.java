package hot100.lc41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc
 * Description:
 *给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * @Author: Luojunjie
 * @Create 2026/5/13 12:45
 * Version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line = br.readLine()) != null){
            line = line.trim();
            if(line.isEmpty()) continue;

            int n = Integer.parseInt(line);
            if(n == 0){ //空数组
                System.out.println(1);
                continue;
            }
            int[] nums = new int[n];
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }
            int res = firstMissingPositive(nums);
            System.out.println(res);
        }

    }
    public static int firstMissingPositive(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; i++){

            while(nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
