package hot100.lc146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * ClassName: Main
 * Package: hot100.lc146
 * Description:请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 *  LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 *  int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 *  void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * @Author: Luojunjie
 * @Create 2026/5/24 21:25
 * Version 1.0
 */

class  LRUCache {
    //双向链表，头部节点是最近访问的
    private class Node {
        int key;
        int value;
        Node pre;
        Node next;

        Node(){}
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity; //链表的容量
    private int size; //维护链表的大小
    private Map<Integer, Node> cache = new HashMap<>(); //存放key和节点的对应关系
    //虚拟头结点和尾节点
    public Node head, tail;

    //初始化LRU缓存
    public LRUCache(int capacity){
        this.capacity = capacity;
        size = 0;
        //注意这里不能写成Node head，这样会定义成局部变量，后面直接报空指针
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    //O(1)获取数据
    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        Node node = cache.get(key);
        //注意：get数据也算访问了，要把它移动到链表头部
        moveToHead(node);
        return node.value;

    }
    //写入数据
    public void put(int key, int value){
        Node node = cache.get(key);
        if(node == null) {
            //key不存在，创建一个节点，并移到链表的头部
            Node newNode = new Node(key, value);
            //注意：也要放在map里
            cache.put(key, newNode);
            addToHead(newNode);
            size++;

            if(size > capacity){
                //插入导致超过capacity，删除链表的尾部节点（最久未使用）
                Node tailNode = removeTail();
                //注意：map中的也要删除！这就是为什么Node要存key
                cache.remove(tailNode.key);
                size--;
            }
        }else{
            //直接更新value，并移到链表的头部
            node.value = value;
            moveToHead(node);
        }
    }

    //移除节点
    private void remove(Node node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }
    //把节点移动到链表头部
    private void addToHead(Node node){
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    //把节点移动到链表头部：先移除，再加到头部
    private void moveToHead(Node node) {
        remove(node);
        addToHead(node);
    }
    //删除链表尾部节点
    private Node removeTail(){
        Node tailNode = tail.pre;
        remove(tailNode);
        return tailNode;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            int capacity = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken()); // 操作总数

            LRUCache cache = new LRUCache(capacity);

            // 使用 StringBuilder 收集所有的 get 结果，最后一次性输出
            StringBuilder sb = new StringBuilder();

            // q 次操作
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());

                if (type == 1) {
                    // type 1 代表 put: 需要再读两个数字 (key, value)
                    int key = Integer.parseInt(st.nextToken());
                    int value = Integer.parseInt(st.nextToken());
                    cache.put(key, value);
                } else if (type == 2) {
                    // type 2 代表 get: 需要再读一个数字 (key)
                    int key = Integer.parseInt(st.nextToken());
                    int result = cache.get(key);
                    sb.append(result).append("\n"); // 只有 get 操作才产生输出
                }
            }

            System.out.print(sb.toString());
        }
    }
}
