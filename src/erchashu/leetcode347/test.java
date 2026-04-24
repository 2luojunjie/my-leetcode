package erchashu.leetcode347;

/**
 * ClassName: test
 * Package: leetcode347
 *
 * @author: 罗骏杰
 * @create: 2025-07-24 12:12
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,2,2,5,6,7,7,7,7,7,8,8,9};
        int k = 4;
        Leetcode347 leetcode347 = new Leetcode347();

        int[] res = new int[k];
        res = leetcode347.topKFrequent(nums, k);
        for(int i : res){
            System.out.println(i);
        }
    }
}