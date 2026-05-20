package hot100.lc24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc24
 * Description: 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * @Author: Luojunjie
 * @Create 2026/5/20 23:19
 * Version 1.0
 */
public class Main {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
            String line;
            while((line = br.readLine()) != null){
                line = line.trim();
                if(line.isEmpty()) continue;
                int n = Integer.parseInt(line);

                ListNode dummy = new ListNode(-1);
                dummy.next = null;
                ListNode curr = dummy;

                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int i = 0; i < n; i++){
                    curr.next = new ListNode(Integer.parseInt(st.nextToken()));
                    curr = curr.next;
                }
                ListNode head = dummy.next;

                ListNode res = swapPairs(head);
                StringBuilder sb = new StringBuilder();
                while (res != null) {
                    sb.append(res.val).append(res.next == null ? "" : " ");
                    res = res.next;
                }
                System.out.println(sb.toString());
            }
        }

        private static ListNode swapPairs(ListNode head){
            if(head == null || head.next == null) return head;
            //关键点：用虚拟头结点
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode prev = dummy;
            while(prev.next != null && prev.next.next != null){
                ListNode p1 = prev.next;
                ListNode p2 = prev.next.next;
                p1.next = p2.next;
                p2.next = p1;
                prev.next = p2;
                prev = prev.next.next;
            }
            return dummy.next;
        }
    }
}
