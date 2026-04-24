package erchashu.leetcode637;

import erchashu.Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * ClassName: AverageOfLevels
 * Package: leetcode637
 *
 * @author: 罗骏杰
 * @create: 2025-07-26 18:23
 * @Description:
 */
public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        if(root != null){
            dq.offer(root);
        }

        while( !dq.isEmpty() ){
            int size = dq.size();
            double sum = 0;
            //每层的节点数目
            int num = size;

            while(size > 0){
                TreeNode node = dq.peek();
                dq.poll();
                sum += node.val;
                if(node.left != null){
                    dq.offer(node.left);
                }
                if(node.right !=null ){
                    dq.offer(node.right);
                }
                size--;
            }
            res.add(sum/num);
        }
        return res;
    }
}