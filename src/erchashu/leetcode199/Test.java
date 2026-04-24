package erchashu.leetcode199;

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

        Integer[] arr = {23,28,null,21,null,6,19,48,8,null,null,null,null,22,31,
                null,null,4,36,34,30,null,null,null,null,27,2,null,null,3,26,null,null,55,
                null,1,null,15,41,null,null,37,39,14,51,null,null,null,null,46,null,32,12,
                null,null,45,9,null,null,29,10,null,null,null,18,43,25,47,50,null,7,null,null,
                null,null,40,44,17,null,null,null,49,null,35,20,11,54,53,5,null,null,52,33,null,
                null,null,16,null,null,42,38,null,null,null,null,13,24,null,null,null,null};
//        Integer[] arr = {1,2,3,null,5,null,4};
        //从数组构建二叉树
        TreeNode tree = BuildTree.buildTree(arr);
        RightSideView lc = new RightSideView();
        List<Integer> list = lc.rightSideView(tree);
        System.out.println(list);
    }
}