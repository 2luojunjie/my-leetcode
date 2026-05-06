package hot100.lc189;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc189
 * Description:
 *
 * @Author: Luojunjie
 * @Create 2026/5/6 20:12
 * Version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            line = line.trim();
            if(line.isEmpty()) continue;
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] nums = new int[n];
            line = br.readLine();
            st = new StringTokenizer(line);
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }
            rotate(nums, k);

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++){
                sb.append(nums[i]).append(i == n - 1 ? "" : " ");
            }
            System.out.println(sb);
        }
    }

    public static void rotate(int[] nums, int k){
        int n = nums.length;
        k = k % n;
        if(k == 0) return;
        //翻转整个数组
        reverse(nums, 0, n - 1);
        //翻转前k个
        reverse(nums, 0, k - 1);
        //翻转后k个
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
