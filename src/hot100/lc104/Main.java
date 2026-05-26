package hot100.lc104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ClassName: Main
 * Package: hot100.lc104
 * Description: 求二叉树的最大深度
 *
 * @Author: Luojunjie
 * @Create 2026/5/26 13:52
 * Version 1.0
 */
class TreeNode{
    int val;
    TreeNode left, right;
    public TreeNode() {}
    public TreeNode(int x){ this.val = x;}
}
public class Main {
    //用队列，层序遍历
    private static int maxDepth(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int depth = 0;
        while( !q.isEmpty() ){
            int levelSize = q.size();
            for(int i = 0; i < levelSize; i++){
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

    //递归
    private static int maxDepth2(TreeNode root){
        if(root == null ) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private static TreeNode buildTee(String[] vals){
        if(vals == null || vals.length == 0) return null;
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int i = 1;
        while( !q.isEmpty() && i < vals.length){
            TreeNode node = q.poll();
            if(!vals[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(node.left);
            }
            i++;
            if(  i < vals.length && !vals[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            line = line.trim();
            if(line.isEmpty()) continue;
            String[] vals = line.split("\\s");
            TreeNode root = buildTee(vals);
            int maxDepth = maxDepth(root);
            System.out.println(maxDepth);
        }
    }

}
