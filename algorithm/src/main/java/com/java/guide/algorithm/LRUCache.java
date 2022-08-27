package com.java.guide.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 设计和实现一个LRUCache（小红书 2022.06 笔试题 / LeetCode No.146）
 *
 * 描述：
 * - LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存；
 * - int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1；
 * - void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」；
 *   当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 请问你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 分析：借用双链表和map实现，双链表保存实际的值，map用来保存key和链表节点的映射关系
 * 参考：https://blog.csdn.net/m0_64491107/article/details/123723028
 */
public class LRUCache {

    private int capacity;
    // 保护节点
    private Node head;
    private Node tail;
    private Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        // 如果没有返回 - 1，
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 存在，则访问的放到头结点后，移除旧节点
        Node node = cache.get(key);
        remove(node);
        insert(head, node);
        return node.value;
    }

    public void put(int key, int value) {
        // 包含值，则更新新的值
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        } else {
            // 插入新值，判断是否超过容量，超过容量，删除tail的前一个
            if (cache.size() == capacity) {
                cache.remove(tail.pre.key);
                remove(tail.pre);
            }
        }
        Node node = new Node(key, value);
        insert(head, node);
        cache.put(key, node);
    }

    void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    void insert(Node o, Node n) {
        // 分别维护插入节点和前后节点的关系

        o.next.pre = n;
        n.next = o.next;

        o.next = n;
        n.pre = o;
    }

    public class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
