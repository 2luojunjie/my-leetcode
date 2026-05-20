package hot100.lc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc2
 * Description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，
 * 并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @Author: Luojunjie
 * @Create 2026/5/20 15:55
 * Version 1.0
 */
public class Main {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            if (st.countTokens() < 2) continue;

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 构造链表
            ListNode l1 = buildList(br.readLine(), n);
            ListNode l2 = buildList(br.readLine(), m);

            ListNode result = addTwoNumbers(l1, l2);

            printList(result);
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry = 0; // 记录进位

        //只要 l1、l2 还有节点，或者进位还没清零，就继续加！
        //这个能避免最后一个进位漏掉，还少了很多判断条件
        while(l1 != null || l2 != null || carry != 0){
            // 如果某一个链表短，空缺的位置就用 0 补齐
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);

            curr = curr.next;
            if(l1 != null ) l1 = l1.next;
            if(l2 != null ) l2 = l2.next;
        }
        return dummy.next;
    }

    //构建链表
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

    // 打印链表
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
}
