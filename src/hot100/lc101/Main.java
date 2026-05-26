package hot100.lc101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * ClassName: Main
 * Package: hot100.lc101
 * Description:
 *
 * @Author: Luojunjie
 * @Create 2026/5/26 22:28
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
            TreeNode root = buildTree(vals);
            boolean res = isSymmetric2(root);
            System.out.println(res);
        }
    }

    private static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return compare(root.left, root.right);
    }

    private static boolean compare(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null || left.val != right.val) return false;
        return compare(left.left, right.right) && compare(left.right, right.left);
    }

    //使用队列，每次成对检查
    private static boolean isSymmetric2(TreeNode root){
        if(root == null) return true;
        //注意：如果实现类是ArrayDeque,是不允许存null值的，后续会报异常，因此改为LinkedList实现类
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root.left);
        dq.offer(root.right);
        while(!dq.isEmpty()){
            TreeNode node1 = dq.poll();
            TreeNode node2 = dq.poll();

            if(node1 == null && node2 == null) continue;
            if(node1 == null || node2 == null || node1.val != node2.val) return false;

            dq.offer(node1.left);
            dq.offer(node2.right);

            dq.offer(node1.right);
            dq.offer(node2.left);
        }
        return true;
    }

    private static TreeNode buildTree(String[] vals){
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
}