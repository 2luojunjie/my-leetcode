package erchashu.leetcode199;

import erchashu.Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * ClassName: RightSideView
 * Package: leetcode199
 *
 * @author: 罗骏杰
 * @create: 2025-07-26 11:13
 * @Description:
 */
//二叉树的右视图
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        if(root != null) {
            dq.offer(root);
        }

        while( !dq.isEmpty() ){
            int size = dq.size();
            if(size == 1){
                TreeNode node = dq.peek();
                res.add(node.val);
                dq.poll();
                if(node.left != null){
                    dq.offer(node.left);
                }

                if(node.right != null){
                    dq.offer(node.right);
                }
            }
            if(size > 1){

                while(size > 1){
                    TreeNode node = dq.peek();
                    dq.poll();
                    size--;
                    if(node.left != null){
                        dq.offer(node.left);
                    }
                    if(node.right != null){
                        dq.offer(node.right);
                    }
                }


                TreeNode node1 = dq.peek();
                res.add(node1.val);
                dq.poll();
                if(node1.left != null) {
                    dq.offer(node1.left);
                }
                if(node1.right != null) {
                    dq.offer(node1.right);
                }
            }
        }
        return res;
    }
}