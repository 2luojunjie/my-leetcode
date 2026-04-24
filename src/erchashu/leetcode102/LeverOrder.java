package erchashu.leetcode102;

import erchashu.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: LeverOrder
 * Package: leetcode102
 *
 * @author: 罗骏杰
 * @create: 2025-07-26 10:02
 * @Description:
 */
//二叉树的层次遍历
public class LeverOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> dq = new LinkedList<>();
        if(root != null) {
            dq.offer(root);
        }
        while( !dq.isEmpty() ) {

            List<Integer> temp = new ArrayList<>();

            //用size标定属于一层的节点
            int size = dq.size();

            while(size > 0){
                TreeNode node = dq.peek();
                temp.add(node.val);
                dq.poll();
                if( node.left != null){
                    dq.offer(node.left);
                }
                if( node.right != null ){
                    dq.offer(node.right);
                }

                size--;
            }

            res.add(temp);
        }

        return res;
    }
}