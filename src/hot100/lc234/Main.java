package hot100.lc234;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc234
 * Description: 给你一个单链表的头节点 head ，
 * 请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * @Author: Luojunjie
 * @Create 2026/5/15 16:38
 * Version 1.0
 */
class ListNode{
    int val;
    ListNode next;

    ListNode(int x) {
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
            int n = Integer.parseInt(line);
            if(n == 0) {
                System.out.println("true");
                continue;
            }
            // 构建链表
            StringTokenizer st = new StringTokenizer(br.readLine());
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            for(int i = 0; i < n; i++){
                curr.next = new ListNode(Integer.parseInt(st.nextToken()));
                curr = curr.next;
            }

            ListNode head = dummy.next;
            boolean res = isPalindrome(head);
            System.out.println(res);
        }
    }


    public  static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        //1. 找中点
        // 快慢指针，fast走两步，slow走一步，fast走到尽头时，slow刚好在中点
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 此时 slow 恰好处于后半部分（或偏右）的起点

        //2. 把后半段链表反转
        ListNode secondHalfHead = reverseList(slow);
        //3. 双指针逐一比对
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        boolean res = true;
        while(p1 != null && p2 != null){
            if(p1.val != p2.val){
                res = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        //4. 还原链表
        slow.next = reverseList(secondHalfHead);
        return res;
    }
    // 反转链表
    private static ListNode reverseList(ListNode head){
        if(head == null) return null;
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

    // 借助数组，双指针从数组两头往中间比对
    private static boolean isPalindrome1(ListNode head) {
        int length = len(head);
        if(length == 1) return true;
        ListNode p = head;
        //空间复杂度是O(n)
        int[] a = new int[length];
        int i = 0;
        while(p != null){
            a[i] = p.val;
            p = p.next;
            i++;
        }

        int left = 0, right = length - 1;
        while(left < right){
            if(a[left] != a[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    private static int len(ListNode head){
        ListNode p = head;
        int n = 0;
        while(p != null){
            n++;
            p = p.next;
        }
        return n;
    }
}
