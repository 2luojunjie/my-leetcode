package hot100.lc25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc25
 * Description:给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * @Author: Luojunjie
 * @Create 2026/5/21 13:20
 * Version 1.0
 */
public class Main {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            line = line.trim();
            if(line.isEmpty()) continue;
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken()); //链表节点个数
            int k = Integer.parseInt(st.nextToken()); //每k个一组

            line = br.readLine();
            st = new StringTokenizer(line);
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            for(int i = 0; i < n; i++){
                curr.next = new ListNode(Integer.parseInt(st.nextToken()));
                curr = curr.next;
            }

            ListNode resNode = reverseKGroup(dummy.next, k);
            while(resNode != null){
                if(resNode.next == null){
                    System.out.print(resNode.val + "");
                }else {
                    System.out.print(resNode.val + " ");
                }

                resNode = resNode.next;
            }

        }
    }

    private static ListNode reverseKGroup(ListNode head, int k){
        if(head == null || k == 1) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //pre指向每组待翻转节点的前驱节点
        ListNode pre = dummy;

        while(pre != null){
            ListNode end = pre;
            for(int i = 0; i < k && end != null; i++){
                end = end.next;
            }

            if(end == null){
                //说明不够k个了，这组不需要翻转
                break;
            }

            //每组的开始节点和下一组的开始节点
            ListNode start = pre.next;
            ListNode nextStart = end.next;
            //该组最后一个节点断开
            end.next = null;
            //独立出来的k个节点，以start为头，执行反转，反转以后要用pre连着
            pre.next = reverse(start);
            start.next = nextStart;
            pre = start;
        }
        return dummy.next;
    }

    //反转一个纯单向链表
    private static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
            ListNode tempNode = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tempNode;
        }
        return pre;
    }

}
