package hot100.lc206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc206
 * Description:
 *
 * @Author: Luojunjie
 * @Create 2026/5/5 22:53
 * Version 1.0
 */
class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = bf.readLine()) != null){
            line = line.trim();
            if(line.isEmpty()) continue;
            int n = Integer.parseInt(line);

            line = bf.readLine();
            StringTokenizer st = new StringTokenizer(line);
            //构建链表技巧：使用dummy虚拟头结点
            ListNode dummy = new ListNode(-1);
            ListNode tail = dummy;
            for(int i = 0; i < n; i++){
                int val = Integer.parseInt(st.nextToken());
                tail.next = new ListNode(val);
                tail = tail.next;
            }
            //真正的头结点是dummy.next
            ListNode head = dummy.next;
            ListNode reverseHead = reverseList(head);
            ListNode curr = reverseHead;
            while(curr != null){
                System.out.print(curr.val + " ");
                curr = curr.next;
            }
        }

    }

    static ListNode reverseList(ListNode head){
        if(head == null) return null;
        //if(head.next == null) return head;
        ListNode curr = head;
        ListNode pre = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
