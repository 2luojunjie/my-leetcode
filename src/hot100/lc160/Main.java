package hot100.lc160;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc160
 * Description: 给你两个单链表的头节点 headA 和 headB ，
 * 请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null
 *
 * @Author: Luojunjie
 * @Create 2026/5/15 11:10
 * Version 1.0
 */
class ListNode{
    int val;
    ListNode next;

    ListNode(int x){
        this.val = x;
        this.next = null;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            line = line.trim();
            if(line.isEmpty()) continue;
            StringTokenizer st = new StringTokenizer(line);
            if(st.countTokens() < 4) continue;
            int n = Integer.parseInt(st.nextToken()); //链表A的全部值
            int m = Integer.parseInt(st.nextToken()); //链表B的全部值
            int skipA = Integer.parseInt(st.nextToken()); //链表A相交节点的索引
            int skipB = Integer.parseInt(st.nextToken()); //链表B相交节点的索引

            //完整构建链表 A，并记录相交的那个物理节点
            ListNode dummyA = new ListNode(0);
            ListNode currA = dummyA;
            ListNode intersectNode = null;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                currA.next = new ListNode(Integer.parseInt(st.nextToken()));
                currA = currA.next;
                if(i == skipA) intersectNode = currA;
            }

            //构建链表 B，并在 skipB 处强行接入 A 的节点
            ListNode dummyB = new ListNode(0);
            ListNode currB = dummyB;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                // 如果到达了相交点，直接让 B 的 next 指向 A 的相交节点，实现物理相交！
                if (i == skipB && intersectNode != null) {
                    currB.next = intersectNode;
                    break; // 后面的公共部分不需要再读取创建了，直接共享 A 的内存
                } else {
                    currB.next = new ListNode(Integer.parseInt(st.nextToken()));
                    currB = currB.next;
                }
            }

            ListNode headA = dummyA.next;
            ListNode headB = dummyB.next;

            ListNode res = getIntersectionNode(headA, headB);
            if(res != null){
                System.out.println("Intersected at " + "'" + res.val + "'");
            }else{
                System.out.println("No intersection");
            }
        }
    }
    private static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        //让pA和pB互相走对方的路
        //指针 pA 从链表 A 的头开始走，走完 A 之后，立刻跳到链表 B 的头节点继续走
        //指针 pB 从链表 B 的头开始走，走完 B 之后，立刻跳到链表 A 的头节点继续走
        //当它们走完各自的独有部分后，必然会同时踩在那个相交的节点上
        while(pA != null || pB != null){
            if(pA == null) pA = headB;
            if(pB == null) pB = headA;
            if(pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;

        }
        return null;
    }

}
