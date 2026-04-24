package erchashu.leetcode226;

import erchashu.Tree.BuildTree;
import erchashu.Tree.TreeNode;
import erchashu.Tree.TreeToArray;

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
        Integer[] arr = {4,2,7,1,3,6,9};
        //从数组构建二叉树
        TreeNode tree = BuildTree.buildTree(arr);
        InvertTree lc = new InvertTree();
        TreeNode tree1 = lc.invertTree(tree);
        Integer[] treeToArray = TreeToArray.treeToArray(tree1);
        for(Integer i : treeToArray){
            System.out.print( i + " ");
        }
    }
}