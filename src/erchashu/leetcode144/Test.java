package erchashu.leetcode144;

import erchashu.Tree.BuildTree;
import erchashu.Tree.TreeNode;

import java.util.List;

/**
 * ClassName: Test
 * Package: leetcode144
 *
 * @author: 罗骏杰
 * @create: 2025-07-25 16:45
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

        Integer[] arr = {1,2,3,4,5,null,8,null,null,6,7,9};
        //从数组构建二叉树
        TreeNode tree = BuildTree.buildTree(arr);
        PreOrder lc = new PreOrder();
        List<Integer> list = lc.preorderTraversal(tree);
        System.out.println(list);
    }
}