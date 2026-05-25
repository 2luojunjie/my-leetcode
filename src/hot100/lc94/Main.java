package hot100.lc94;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * ClassName: Main
 * Package: hot100.lc94
 * Description: 树的中序遍历
 *
 * @Author: Luojunjie
 * @Create 2026/5/25 19:37
 * Version 1.0
 */

public class Main {

    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){
            this.val = x;
        }
    }

    //递归遍历
    private static void inorderTraversal(TreeNode root, List<Integer> res){
        if(root == null) return;
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);

    }

    //迭代遍历
    private static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        TreeNode curr = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || curr != null){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    //将层序遍历字符串数组转化为二叉树 (利用 Queue)
    private static TreeNode buildTree(String[] vals){
        if (vals.length == 0 || vals[0].equals("null")) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty() && i < vals.length){
            TreeNode curr = queue.poll();
            if(!vals[i].equals("null")){
                curr.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(curr.left);
            }
            i++;
            if(i < vals.length && !vals[i].equals("null")){
                curr.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            // 读取用空格隔开的层序遍历字符串，例如：1 null 2 3
            String[] vals = line.split("\\s+");

            // 1. 根据层序数组，构建二叉树
            TreeNode root = buildTree(vals);
            List<Integer> result = inorderTraversal(root);
            printList(result);
        }
    }

    private static void printList(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(i == list.size() - 1 ? "" : " ");
        }
        System.out.println(sb.toString());
    }
}
