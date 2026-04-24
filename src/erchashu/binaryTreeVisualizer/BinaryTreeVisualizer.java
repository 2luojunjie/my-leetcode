package erchashu.binaryTreeVisualizer;

/**
 * ClassName: TreeSwingVisualizer
 * Package: leetcode199
 *
 * @author: 罗骏杰
 * @create: 2025-07-26 11:24
 * @Description:
 */

/**
 * 二叉树可视化
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int x, y;  // 节点坐标
    TreeNode(int val) { this.val = val; }
}

public class BinaryTreeVisualizer extends JFrame {
    private TreeNode root;
    private static final int NODE_RADIUS = 25;  // 节点半径
    private static final int H_GAP = 80;        // 水平间距
    private static final int V_GAP = 100;       // 垂直间距
    private double scale = 1.0;                 // 缩放比例
    private Point offset = new Point(0, 0);     // 偏移量（用于拖动）
    private Point dragStart = null;             // 拖动起始点

    // 从数组构建二叉树（层序遍历方式）
    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // 添加左子节点
            if (arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // 添加右子节点
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public BinaryTreeVisualizer(TreeNode root) {
        this.root = root;
        setTitle("二叉树可视化");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 添加鼠标滚轮缩放和拖动功能
        addMouseWheelListener(e -> {
            double oldScale = scale;
            scale *= e.getWheelRotation() < 0 ? 1.1 : 0.9;
            scale = Math.max(0.2, Math.min(3.0, scale));  // 限制缩放范围

            // 保持鼠标位置不变
            Point mouse = e.getPoint();
            offset.x = (int) (offset.x * scale / oldScale + mouse.x * (1 - scale / oldScale));
            offset.y = (int) (offset.y * scale / oldScale + mouse.y * (1 - scale / oldScale));
            repaint();
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dragStart = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragStart != null) {
                    offset.x += e.getX() - dragStart.x;
                    offset.y += e.getY() - dragStart.y;
                    dragStart = e.getPoint();
                    repaint();
                }
            }
        });
    }

    // 计算节点坐标（递归）
    private void calculateCoordinates(TreeNode node, int x, int y) {
        if (node == null) return;
        node.x = x;
        node.y = y;
        calculateCoordinates(node.left, x - H_GAP, y + V_GAP);
        calculateCoordinates(node.right, x + H_GAP, y + V_GAP);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // 应用缩放和偏移
        g2d.scale(scale, scale);
        g2d.translate(offset.x / scale, offset.y / scale);

        // 启用抗锯齿
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 计算节点坐标
        if (root != null) {
            calculateCoordinates(root, getWidth() / 2, 100);
            drawTree(g2d, root);  // 绘制树
        }
    }

    // 绘制树（节点 + 边）
    private void drawTree(Graphics2D g, TreeNode node) {
        if (node == null) return;

        // 绘制左子树连线
        if (node.left != null) {
            g.setColor(Color.GRAY);
            g.setStroke(new BasicStroke(2.0f));
            g.drawLine(node.x, node.y, node.left.x, node.left.y);
        }

        // 绘制右子树连线
        if (node.right != null) {
            g.setColor(Color.GRAY);
            g.setStroke(new BasicStroke(2.0f));
            g.drawLine(node.x, node.y, node.right.x, node.right.y);
        }

        // 绘制当前节点
        g.setColor(Color.WHITE);
        g.fillOval(node.x - NODE_RADIUS, node.y - NODE_RADIUS, 2 * NODE_RADIUS, 2 * NODE_RADIUS);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(2.0f));
        g.drawOval(node.x - NODE_RADIUS, node.y - NODE_RADIUS, 2 * NODE_RADIUS, 2 * NODE_RADIUS);

        // 绘制节点值
        Font font = new Font("Arial", Font.BOLD, 14);
        g.setFont(font);
        FontMetrics metrics = g.getFontMetrics(font);
        String text = String.valueOf(node.val);
        g.drawString(text, node.x - metrics.stringWidth(text) / 2, node.y + 5);

        // 递归绘制子树
        drawTree(g, node.left);
        drawTree(g, node.right);
    }

    public static void main(String[] args) {
        // 示例数组：层序遍历表示 [1,2,3,4,5,null,6]
//        Integer[] arr = {23,28,null,21,null,6,19,48,8,null,null,null,null,22,31,null,null,
//                4,36,34,30,null,null,null,null,27,2,null,null,3,26,null,null,55,null,1,null
//                ,15,41,null,null,37,39,14,51,null,null,null,null,46,null,32,12,null,null
//                ,45,9,null,null,29,10,null,null,null,18,43,25,47,50,null,7,null,null,null
//                ,null,40,44,17,null,null,null,49,null,35,20,11,54,53,5,null,null,52,33,null
//                ,null,null,16,null,null,42,38,null,null,null,null,13,24,null,null,null,null};

        Integer[] arr = {1,2,2,3,3,null,null,4,4};
        // 构建二叉树
        TreeNode root = buildTree(arr);

        // 显示窗口
        SwingUtilities.invokeLater(() -> {
            new BinaryTreeVisualizer(root).setVisible(true);
        });
    }
}