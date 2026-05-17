package hot100.lc21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc21
 * Description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @Author: Luojunjie
 * @Create 2026/5/17 23:42
 * Version 1.0
 */
public class Main {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            if (st.countTokens() < 2) continue; // 防御

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 构造链表
            ListNode list1 = buildList(br.readLine(), n);
            ListNode list2 = buildList(br.readLine(), m);

            ListNode mergedHead = mergeTwoLists(list1, list2);
            printList(mergedHead);
        }
    }

    private static ListNode buildList(String line, int len) {
        if (len == 0 || line == null) return null;
        StringTokenizer st = new StringTokenizer(line);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int i = 0; i < len; i++) {
            curr.next = new ListNode(Integer.parseInt(st.nextToken()));
            curr = curr.next;
        }
        return dummy.next;
    }

    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println();
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(head.next == null ? "" : " ");
            head = head.next;
        }
        System.out.println(sb.toString());
    }

    // 虚拟头节点 + 双指针
    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy; // 游标，负责串联新链表

        // 两个链表都没走完时，谁小就挂谁
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next; // 游标也要往前走一步，准备挂下一个
        }
        //肯定有一个链表先走完，把剩下的那串连接
        curr.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}
