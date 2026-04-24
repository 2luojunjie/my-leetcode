package erchashu.leetcode102;
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

//        Integer[] arr = {1,2,3,4,5,null,8,null,null,6,7,9};
//        Integer[] arr = {1,null,2,3};
        Integer[] arr = {3,9,20,null,null,15,7};
        //从数组构建二叉树
        TreeNode tree = BuildTree.buildTree(arr);
        LeverOrder lc = new LeverOrder();
        List<List<Integer>> res = lc.levelOrder(tree);
        System.out.println(res);
    }
}