package erchashu.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: BuildTree
 * Package: leetcode144
 *
 * @author: 罗骏杰
 * @create: 2025-07-25 16:48
 * @Description:
 */

//从数组构建二叉树
public class BuildTree {

    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // 添加左子节点
            if (arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // 添加右子节点
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

}