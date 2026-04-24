package erchashu.leetcode111;

import erchashu.Tree.TreeNode;

/**
 * ClassName: MinDepth
 * Package: leetcode111
 *
 * @author: 罗骏杰
 * @create: 2025-07-29 10:57
 * @Description:
 */
//二叉树的最小深度
public class MinDepth {

    public static int minDepth(TreeNode root) {
        int minReult;
        if(root == null) return 0;
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);

        if(root.left == null && root.right != null){
            return 1 + minRight;
        }
        if(root.left != null && root.right == null){
            return 1 + minLeft;
        }

        minReult = 1 + Math.min(minLeft, minRight);
        return minReult;
    }
}