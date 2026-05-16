package hot100.lc141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc141
 * Description: 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * @Author: Luojunjie
 * @Create 2026/5/16 19:57
 * Version 1.0
 */
class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x){
        this.val = x;
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
            int n = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            if(n == 0) {
                System.out.println("false");
                continue;
            }

            st = new StringTokenizer(br.readLine());
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            ListNode cycleNode = null; //记录环的入口节点

            for(int i = 0; i < n; i++){
                curr.next = new ListNode(Integer.parseInt(st.nextToken()));
                curr = curr.next;
                if(i == pos) {
                    cycleNode = curr;
                }
            }
            if(pos != -1 && cycleNode != null) curr.next = cycleNode;

            boolean res = hasCycle(dummy.next);
            System.out.println(res);

        }
    }

    private static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head, fast = head;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
