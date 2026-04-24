package erchashu.leetcode94;

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
        Integer[] arr = {5,4,6,1,2,null,null};
        //从数组构建二叉树
        TreeNode tree = BuildTree.buildTree(arr);
        MidOrder02 lc = new MidOrder02();
        List<Integer> list = lc.inorderTraversal(tree);
        System.out.println(list);
    }
}