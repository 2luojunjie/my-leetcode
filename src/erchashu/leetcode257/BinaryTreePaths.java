package erchashu.leetcode257;

import erchashu.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: BinaryTreePaths
 * Package: leetcode257
 *
 * @author: 罗骏杰
 * @create: 2025-07-30 20:45
 * @Description:
 */
//求二叉树的所有路径
public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        getPath(root, path, res);
        return res;
    }

    public static void getPath(TreeNode node, List<Integer> path, List<String> res){

        //前序遍历
        //中
        path.add(node.val);
        //遍历到叶子结点时处理
        if(node.left == null && node.right == null){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
                if (i < path.size() - 1) {
                    sb.append("->");  // 非最后一个元素，添加 "->"
                }
            }
            res.add(sb.toString());
        }

        //左
        if(node.left != null) {
            getPath(node.left, path, res);
            path.remove(path.size() - 1);
        }
        //右
        if(node.right != null) {
            getPath(node.right, path, res);
            path.remove((path.size() - 1));
        }
    }
}