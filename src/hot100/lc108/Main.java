package hot100.lc108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: Main
 * Package: hot100.lc108
 * Description: 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 *
 * @Author: Luojunjie
 * @Create 2026/5/27 14:47
 * Version 1.0
 */
public class Main {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    // 分治法构建平衡 BST
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return buildBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // (left + right) / 2 可能会导致整型溢出 (Integer Overflow)
        // 标准的安全写法是 left + (right - left) / 2
        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }

            TreeNode root = sortedArrayToBST(nums);

            // 按力扣的标准格式 [0,-3,9,-10,null,5] 打印这棵树
            printTreeLevelOrder(root);
        }
    }

    // 辅助工具：将二叉树序列化为层序数组格式
    private static void printTreeLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        List<String> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // BFS 遍历，记录所有的节点（包括 null）
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                res.add(String.valueOf(curr.val));
                queue.offer(curr.left);
                queue.offer(curr.right);
            } else {
                res.add("null");
            }
        }

        // 去除尾部多余的 "null"
        while (res.size() > 0 && res.get(res.size() - 1).equals("null")) {
            res.remove(res.size() - 1);
        }

        System.out.println("[" + String.join(",", res) + "]");
    }
}
