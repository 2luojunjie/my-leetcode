package hot100.lc148;

import hot100.lc148.Main.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc148
 * Description:给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * @Author: Luojunjie
 * @Create 2026/5/24 12:27
 * Version 1.0
 */
public class Main {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
            this.next = null;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            int n = Integer.parseInt(line);
            if (n == 0) {
                System.out.println();
                continue;
            }

            // 读取链表
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            for (int i = 0; i < n; i++) {
                curr.next = new ListNode(Integer.parseInt(st.nextToken()));
                curr = curr.next;
            }

            ListNode sortedHead = sortList(dummy.next);

            // 标准化输出
            printList(sortedHead);
        }
    }

    //时间复杂度为O(nlogn)，使用归并排序
    private static ListNode sortList(ListNode head){
        if(head == null || head.next == null) return head;
        // 找链表的中点
        ListNode curr = head;
        ListNode fast = head.next, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        //切断，分为两半
        slow.next = null;
        //递归

        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        // 归并排序，合并两个有序链表
        return mergeTwoLists(left, right);
    }

    //归并两个链表
    private static ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(left != null && right != null){
            if(left.val <= right.val){
                curr.next = left;
                left = left.next;
            }else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = (left != null) ? left : right;
        return dummy.next;
    }

    private static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(head.next == null ? "" : " ");
            head = head.next;
        }
        System.out.println(sb.toString());
    }
}
