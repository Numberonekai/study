package com.java.main.algorithm;

import lombok.Data;

/**
 * 单项链表
 *
 * @auther: kai2.wang
 * @date: 2019/11/5 13:57
 * @description:
 * @version: 1.0
 */
public class MyList {

    //添加头结点
    public static void addHeadNode(Node head, Node newHeader) {
        Node old = head;
        head = newHeader;
        head.next = old;
    }

    //尾结点添加
    public static void addEndNode(Node end, Node newEnd) {
        Node old = end;
//        old=newEnd;
        end.next = newEnd;
    }

    //列表
    public static void list(Node node) {
        while (node != null) {
            System.out.print(node.name);
            node = node.next;
        }
        System.out.println();
    }

    //列表搜索
    public static void listByName(Node node, String name) {
        int count = 0;
        while (node != null) {
            if (node.next != null && node.name.equals(name)) {
                break;
            }
            count++;
            node = node.next;
        }
        System.out.println(count);
    }

    //插入
    public static void insertNode(Node p, Node s) {
        Node next = p.next;
        s.next = next;
        p.next = s;
    }

    //删除
    public static void delNode(Node pre, Node q) {
        if (q != null && q.next != null) {
            Node old = q.next;
            q.name = old.name;
            q.next = old.next;
            old = null;
        } else {
            while (pre != null) {
                if (pre.next != null && pre.next == q) {
                    pre.next = null;
                    break;
                }
                pre = pre.next;
            }
        }
    }

    //翻转
    public static Node reverseData(Node node) {
        Node pre = null;
        while (node != null) {
            Node old = node.next;
            node.next = pre;
            pre = node;
            node = old;
        }
        return  pre;
    }

    public static void middleData(Node node) {
        Node fast = node;
        Node slow = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println(slow);
    }

    public static void main(String[] args) {
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        Node node6 = new Node("F");

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("----全部-----");
        list(node1);


        System.out.println("----查找某个节点-----");
        listByName(node1, "C");

        System.out.println("----添加投节点-----");
        addHeadNode(node1, node5);
        list(node5);

        System.out.println("----添加尾节点-----");
        addEndNode(node4, node6);
        list(node5);

        System.out.println("----插入节点-----");
        Node node7 = new Node("G");
        insertNode(node2, node7);
        list(node5);

        System.out.println("----删除节点-----");
        Node node8 = new Node("H");
        delNode(node5, node6);
        list(node5);

        System.out.println("----控制翻转-----");
        list(reverseData(node5));

        System.out.println("----获取中间节点------");
        middleData(node5);
    }

    @Data
    public static class Node {
        String name;
        Node next;

        public Node(String name) {
            this.name = name;
        }


    }


}
