package erchashu.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: TreeToArray
 * Package: Tree
 *
 * @author: 罗骏杰
 * @create: 2025-07-27 18:33
 * @Description:
 */
public class TreeToArray {

    public static Integer[] treeToArray(TreeNode root) {
        if (root == null) return new Integer[0];

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 层序遍历
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node != null ? node.val : null);

            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        // 移除末尾连续的 null
        int lastNonNullIndex = -1;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) != null) {
                lastNonNullIndex = i;
                break;
            }
        }

        return list.subList(0, lastNonNullIndex + 1).toArray(new Integer[0]);
    }
}