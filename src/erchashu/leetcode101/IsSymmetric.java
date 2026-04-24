package erchashu.leetcode101;

import erchashu.Tree.TreeNode;

/**
 * ClassName: IsSymmetric
 * Package: leetcode101
 *
 * @author: 罗骏杰
 * @create: 2025-07-28 14:55
 * @Description:
 */
//对称二叉树
public class IsSymmetric {

    public static boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    public static boolean compare(TreeNode left, TreeNode right){
        if(left != null && right == null) return false;
        if(left == null && right != null) return false;
        if(left == null && right == null) return true;
        if(left.val != right.val) return false;
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        boolean result = outside && inside;
        return result;
    }
}