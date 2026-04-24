package erchashu.leetcode94;

import erchashu.Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * ClassName: MidOrder02
 * Package: leetcode94
 *
 * @author: 罗骏杰
 * @create: 2025-07-25 22:26
 * @Description:
 */
//中序遍历 非递归
public class MidOrder02 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        TreeNode cur = root;
        while( !dq.isEmpty() || cur != null){
            if(cur != null){
                dq.push(cur);
                //一直向左下遍历，直至左孩子为空
                cur = cur.left;
            }else{
                //没有左孩子时，当前节点就是待处理节点。出栈，存入数组，并寻找右孩子
                cur = dq.peek();
                res.add(cur.val);
                dq.poll();
                cur = cur.right;
            }
        }
        return res;
    }
}