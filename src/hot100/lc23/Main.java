package hot100.lc23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc23
 * Description:给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * @Author: Luojunjie
 * @Create 2026/5/25 16:51
 * Version 1.0
 */
class ListNode{
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int x){
        this.val = x;
        this.next = null;
    }
}

class MinHeap{
    private ListNode[] heap;
    private int size;

    public MinHeap(int capacity) {
        heap = new ListNode[capacity];
        size = 0;
    }
    public void offer(ListNode node){
        if(node == null) return;
        heap[size] = node;
        Up(size);//上浮操作
        size++;
    }

    public ListNode poll(){
        if(size == 0) return null;
        ListNode node = heap[0];
        ListNode lastNode = heap[size-1];
        size--;
        if(size > 0){
            //把最后一个节点放到最前面，然后下沉
            heap[0] = lastNode;
            Down(0);
        }
        return node;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    private void Up(int i){
        ListNode node = heap[i];
        while(i > 0){
            int parent = (i-1) / 2;//父节点
            if(node.val >= heap[parent].val){
                break;
            }
            heap[i] = heap[parent];
            i = parent;
        }
        heap[i] = node;
    }

    private void Down(int i){
        ListNode node = heap[i];
        int half = size / 2;//只有非叶子节点才需要下沉
        while(i < half){
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            int minChild = left;
            if(right < size && heap[left].val > heap[right].val) minChild = right;
            if(node.val <= heap[minChild].val) break;
            heap[i] = heap[minChild];
            i = minChild;
        }
        heap[i] = node;
    }

}

public class Main {


    private static ListNode mergeLists(ListNode[] lists){
        if(lists == null || lists.length == 0) return null;
        //最小的数肯定是某一个头结点，把这个头结点合并以后，下一个最小的要么是另一个头结点，要么是该头结点的next
        //小顶堆，按照节点的val值升序排列
        // PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) ->  a.val - b.val);
        // PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
        //     public int compare(ListNode a, ListNode b){
        //         return a.val - b.val;
        //     }
        // });
        MinHeap pq = new MinHeap(lists.length);
        for(ListNode head : lists){
            if(head != null) pq.offer(head);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while( !pq.isEmpty() ){
            //小顶堆 根节点是最小的数
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;
            if(minNode.next != null){
                pq.offer(minNode.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            // 读取链表总条数 K
            int k = Integer.parseInt(line);
            if (k == 0) {
                System.out.println();
                continue;
            }

            ListNode[] lists = new ListNode[k];
            for (int i = 0; i < k; i++) {
                // 读取当前链表的长度 n
                String lenLine = br.readLine();
                int n = Integer.parseInt(lenLine.trim());
                if (n == 0) {
                    lists[i] = null;
                    continue;
                }

                // 读取 n 个节点值，单链表
                StringTokenizer st = new StringTokenizer(br.readLine());
                ListNode dummy = new ListNode(-1);
                ListNode curr = dummy;
                for (int j = 0; j < n; j++) {
                    curr.next = new ListNode(Integer.parseInt(st.nextToken()));
                    curr = curr.next;
                }
                lists[i] = dummy.next;
            }

            ListNode sortedHead = mergeLists(lists);

            printList(sortedHead);
        }
    }

    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println();
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(head.next != null ? " " : "");
            head = head.next;
        }
        System.out.println(sb.toString());
    }

}
