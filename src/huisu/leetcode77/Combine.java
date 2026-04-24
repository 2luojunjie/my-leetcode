package huisu.leetcode77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Combine
 * Package: huisu.leetcode77
 *
 * @author: 罗骏杰
 * @create: 2025-08-06 16:35
 * @Description:
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, path, result);
        return result;
    }

    public void backtrack(int n, int k, int startIndex, LinkedList<Integer> path, List<List<Integer>> result){
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i <= n; i++) {
            path.add(i);
            backtrack(n, k, i+1, path, result);
            path.removeLast();
        }
    }
}

public class Combine {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combine(n, k);
        System.out.println(result);
    }
}