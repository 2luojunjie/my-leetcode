package hot100.lc560;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ClassName: Main
 * Package: hot100.lc560
 * Description:
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 *
 * 子数组是数组中元素的连续非空序列。
 *
 * @Author: Luojunjie
 * @Create 2026/4/28 21:26
 * Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = scanner.nextInt();
            }

            int count = subarraySum(nums, k);
            System.out.print(count);
        }

        scanner.close();
    }

    public static int subarraySum(int[] nums, int k){
        int count = 0;
        int pre = 0;//当前的前缀和

        // Key:前缀和的值，Vaule:该前缀和出现的次数
        Map<Integer,Integer> map = new HashMap();

        // 【关键初始化】：前缀和为 0 的情况出现过 1 次
        // 意义：如果当前 pre 本身就等于 k，那么 pre - k = 0。我们需要 map 里有 0 才能匹配到。
        map.put(0, 1);

        for(int i = 0; i < nums.length; i++) {
            pre += nums[i];

            if(map.containsKey(pre-k)){
                count += map.get(pre-k);
            }

            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
