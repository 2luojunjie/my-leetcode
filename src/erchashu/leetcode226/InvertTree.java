package erchashu.leetcode226;

import erchashu.Tree.TreeNode;

/**
 * ClassName: InvertTree
 * Package: leetcode226
 *
 * @author: 罗骏杰
 * @create: 2025-07-27 18:30
 * @Description:
 */
//翻转二叉树
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null ) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}