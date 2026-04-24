package erchashu.leetcode94;

import erchashu.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MidOrder
 * Package: leetcode94
 *
 * @author: 罗骏杰
 * @create: 2025-07-25 17:12
 * @Description:
 */

//中序遍历 递归
public class MidOrder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        midOrder(root, res);
        return res;
    }

    public void midOrder(TreeNode root, List<Integer> res){
        if(root == null) return;
        midOrder(root.left, res);
        res.add(root.val);
        midOrder(root.right, res);
    }
}