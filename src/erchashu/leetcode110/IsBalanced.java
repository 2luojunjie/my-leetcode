package erchashu.leetcode110;

import erchashu.Tree.TreeNode;

/**
 * ClassName: IsBalanced
 * Package: leetcode110
 *
 * @author: 罗骏杰
 * @create: 2025-07-29 17:11
 * @Description:
 */
public class IsBalanced {
    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        int hLeft = getHeight(root.left);
        int hRight = getHeight(root.right);
        return Math.abs(hLeft-hRight) <= 1;
    }

    public static int getHeight(TreeNode root){
        if(root == null ) return 0;
        int leftDepth = getHeight(root.left);
        int rightDepth = getHeight(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}