package erchashu.leetcode347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 *
 * @author: 罗骏杰
 * @create: 2025-07-24 12:10
 * @Description: 前k个高频元素
 */
public class Leetcode347 {
    //优先级队列
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //创建map。存储元素及其频率。
        for(int i = 0; i < nums.length; i++){
            int key = nums[i];
            if(map.containsKey(key)){
                int value = map.get(key);
                value++;
                map.put(key, value);
            }else{
                map.put(key, 1);
            }
        }
        //优先级队列，基于小根堆，按照value值从小到大排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            //将小的弹出，剩下的就是大的
            if(pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        for(int i = k-1; i >=0; i--){
            res[i] = pq.poll()[0];
        }

        return res;
    }
}