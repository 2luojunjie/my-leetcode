package hot100.lc141.lc142;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc141.lc142
 * Description:
 *
 * @Author: Luojunjie
 * @Create 2026/5/17 23:06
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

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            if (n == 0) {
                System.out.println("null");
                continue;
            }

            // --- 构建带环链表 ---
            st = new StringTokenizer(br.readLine());
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;
            ListNode cycleNode = null;

            for (int i = 0; i < n; i++) {
                curr.next = new ListNode(Integer.parseInt(st.nextToken()));
                curr = curr.next;
                if (i == pos) {
                    cycleNode = curr;
                }
            }

            // 尾部连接到 pos 形成环
            if (pos != -1 && cycleNode != null) {
                curr.next = cycleNode;
            }

            //
            ListNode result = detectCycle(dummy.next);

            // 标准化输出
            if (result != null) {
                System.out.println(result.val);
            } else {
                System.out.println("null");
            }
        }
    }

    private static ListNode detectCycle(ListNode head){
        if(head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        ListNode cycleNode = null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) { //相遇
                ListNode p1 = slow;
                ListNode p2 = head;
                // 原理是从head走到环的入口，会等于从相遇点往前走回到入口（或者是n倍）
                // 总之，在相遇点和head同时以相同速度往前走，最终会在入口相遇
                while(p1 != p2 && p1 != null && p2 != null){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                cycleNode = p1;
                return cycleNode;
            }
        }
        return null;
    }
}
