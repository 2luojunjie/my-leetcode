package hot100.lc138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc138
 * Description:
 * 你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 *
 * @Author: Luojunjie
 * @Create 2026/5/23 20:42
 * Version 1.0
 */
public class Main {
    static class Node{
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
        Node(int val, Node next){
            this.val = val;
            this.next = next;
            this.random = null;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null) {
            line = line.trim();
            if(line.isEmpty()) continue;
            // n代表链表的长度
            int n = Integer.parseInt(line);
            //读取节点val
            int[] vals = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                vals[i] = Integer.parseInt(st.nextToken());
            }
            // 读取random随即指针索引值
            int[] randomIndex = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                randomIndex[i] = Integer.parseInt(st.nextToken());
            }
            //构建链表
            Node[] oldNodes = new Node[n];
            for(int i = 0; i < n; i++){
                oldNodes[i] = new Node(vals[i]);
            }
            for(int i = 0; i < n-1; i++){
                oldNodes[i].next = oldNodes[i+1];
            }
            for(int i = 0; i < n; i++){
                if(randomIndex[i] != -1){
                    // 索引-1 表示该节点的random指向null
                    oldNodes[i].random = oldNodes[randomIndex[i]];
                }
            }

            Node newNodesHead = copyRandomList(oldNodes[0]);

            //输出
            Node[] newNodes = new Node[n];
            Node curr = newNodesHead;
            for(int i = 0; i < n; i++) {
                newNodes[i] = curr;
                curr = curr.next;
            }
            StringBuilder sbVals = new StringBuilder();
            StringBuilder sbRandoms = new StringBuilder();
            for(int i = 0; i < n; i++){
                sbVals.append(newNodes[i].val).append(i == n - 1 ? "" : " ");
                if(newNodes[i].random == null) {
                    sbRandoms.append(-1).append(i == n-1 ? "" : " ");
                }else{
                    for(int j = 0; j < n; j++){
                        if(newNodes[i].random == newNodes[j]) {
                            sbRandoms.append(j).append(i == n - 1 ? "" : " ");
                            break;
                        }
                    }
                }
            }
            System.out.println(sbVals);
            System.out.println(sbRandoms);
        }
    }

    private static Node copyRandomList(Node head) {
        //交叉节点
        Node curr = head;
        while(curr != null){
            //复制每个节点，把新结点直接插在原节点后面
            curr.next = new Node(curr.val, curr.next);
            curr = curr.next.next;
        }
        //找random
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        //拆分链表
        curr = head;
        Node dummy = new Node(0);
        Node tail = dummy;
        while(curr != null){
            //tail连上新结点
            tail.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            tail = tail.next;
        }

        return dummy.next;
    }
}
