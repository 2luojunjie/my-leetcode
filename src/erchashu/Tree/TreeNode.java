package erchashu.Tree;

/**
 * ClassName: TreeNode
 * Package: leetcode144
 *
 * @author: 罗骏杰
 * @create: 2025-07-25 16:42
 * @Description:
 */

//二叉树的节点定义
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}