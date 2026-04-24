package erchashu.leetcode144;


import erchashu.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: LeetCode144
 * Package: leetcode144
 *
 * @author: 罗骏杰
 * @create: 2025-07-25 16:42
 * @Description:
 */
//前序遍历 递归实现

public class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }


    //递归
    public void preOrder(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
}