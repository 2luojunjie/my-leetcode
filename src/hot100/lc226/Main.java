package hot100.lc226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName: Main
 * Package: hot100.lc226
 * Description: 翻转二叉树
 *
 * @Author: Luojunjie
 * @Create 2026/5/26 21:07
 * Version 1.0
 */
class TreeNode{
    int val;
    TreeNode left, right;
    public TreeNode(){}
    public TreeNode(int x){this.val = x;}
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            line = line.trim();
            if(line.isEmpty()) continue;
            String[] vals = line.split("\\s");
            TreeNode root = buildTee(vals);
            TreeNode newRoot = invertTree3(root);
            printTree(newRoot);
        }
    }

    //递归法
    private static TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    //队列
    private static TreeNode invertTree2(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        if(root != null){
            dq.offer(root);
        }

        while( !dq.isEmpty() ){
            TreeNode node = dq.peek();
            dq.poll();
            swap(node);
            if(node.left != null){
                dq.offer(node.left);
            }
            if(node.right != null){
                dq.offer(node.right);
            }
        }
        return root;
    }

    //栈
    private static TreeNode invertTree3(TreeNode root){
        Deque<TreeNode> dq = new ArrayDeque<>();
        if(root != null){
            dq.push(root);
        }

        while( !dq.isEmpty() ){
            TreeNode node = dq.peek();
            dq.pop();
            swap(node);
            if(node.right != null){
                dq.offer(node.right);
            }
            if(node.left != null){
                dq.offer(node.left);
            }
        }
        return root;
    }

    private static void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    //利用队列层序遍历建树
    private static TreeNode buildTee(String[] vals){
        if(vals == null || vals.length == 0) return null;
        Deque<TreeNode> dq = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        dq.offer(root);
        int i = 1;
        while(!dq.isEmpty() && i < vals.length){
            TreeNode node = dq.poll();
            if(!vals[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                dq.offer(node.left);
            }
            i++;
            if(!vals[i].equals("null") && i < vals.length){
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                dq.offer(node.right);
            }
            i++;
        }
        return root;
    }

    private static void printTree(TreeNode root){
        if(root == null) return;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while(!dq.isEmpty()){
            TreeNode node = dq.poll();
            System.out.print(node.val + " ");
            if(node.left != null) dq.offer(node.left);
            if(node.right != null) dq.offer(node.right);
        }
    }

}
