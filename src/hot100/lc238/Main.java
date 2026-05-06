package hot100.lc238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName:
 * Package: hot100.lc238
 * Description:给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除了 nums[i]
 * 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * @Author: Luojunjie
 * @Create 2026/5/6 20:41
 * Version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // 快读
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            // 读取数组长度
            int n = Integer.parseInt(line);
            if (n == 0) {
                System.out.println();
                continue;
            }

            // 读取数组元素
            int[] nums = new int[n];
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            // 调用核心算法
            int[] ans = productExceptSelf2(nums);

            // 标准化输出
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(ans[i]).append(i == n - 1 ? "" : " ");
            }
            System.out.println(sb);
        }
    }
    //暴力超时了
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            int t = 1;
            for(int j = 0; j < n; j++){
                if(j != i) t = t * nums[j];
            }
            answer[i] = t;
        }
        return answer;
    }

    //前缀积 后缀积
    public static int[] productExceptSelf2(int[] nums){
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;
        //每个元素左边的乘积
        for(int i = 1; i < n; i++){
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int R = 1;
        //右边的乘积并乘进answer里
        for(int i = n - 1; i >= 0; i--){
            answer[i] = answer[i] * R;
            R = R * nums[i];
        }
        return answer;
    }
}
