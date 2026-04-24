package erchashu.leetcode257;

import erchashu.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: BinaryTreePaths02
 * Package: leetcode257
 *
 * @author: 罗骏杰
 * @create: 2025-07-30 21:08
 * @Description:
 */
public class BinaryTreePaths02 {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<Object> stack = new Stack<>();
        // 节点和路径同时入栈
        stack.push(root);
        stack.push(root.val + "");
        while (!stack.isEmpty()) {
            // 节点和路径同时出栈
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            // 若找到叶子节点
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            //右子节点不为空
            if (node.right != null) {
                stack.push(node.right);
                stack.push(path + "->" + node.right.val);
            }
            //左子节点不为空
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }
        return result;
    }
}