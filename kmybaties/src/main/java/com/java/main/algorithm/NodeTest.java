package com.java.main.algorithm;

import lombok.Data;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @auther: kai2.wang
 * @date: 2019/10/31 11:38
 * @description:
 * @version: 1.0
 */
public class NodeTest {

    //前序排序  根  左  右
    public static void preDigui(Node node) {
        while (node != null) {
            System.out.print(node.name + "  ");
            preDigui(node.leftNode);
            preDigui(node.rightNode);
            break;
        }
    }

    //中序排列 左 根  右
    public static void centerDigui(Node node) {
        while (node != null) {
            centerDigui(node.leftNode);
            System.out.print(node.name + "  ");
            centerDigui(node.rightNode);
            break;
        }
    }

    public static void postDigui(Node node) {
        while (node != null) {
            postDigui(node.leftNode);
            postDigui(node.rightNode);
            System.out.print(node.name + "  ");
            break;
        }
    }

    //层次递归
    public static void allDigui(Node node) {
        Queue queue = new LinkedList();
        queue.add(node);

        while (queue != null && !queue.isEmpty()) {
            Node node1 = (Node) queue.poll();
            System.out.print(node1.name + "  ");
            if (node1.leftNode != null) {
                queue.add(node1.leftNode);
            }
            if (node1.rightNode != null) {
                queue.add(node1.rightNode);
            }
        }
    }


    //非层次递归----前序
    public static void preFor(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                System.out.print(node.name + "  ");
                stack.push(node);
                node = node.leftNode;
            }else{
                Node node1 = stack.pop();
                node = node1.rightNode;
            }
        }
    }

    //非层次递归----中序
    public static void centerFor(Node node) {
        Stack<Node> stack = new Stack<>();
        while(node!=null || !stack.empty()){
            if(node!=null){
                stack.add(node);
                node=node.leftNode;
            }else{
                Node node1=stack.pop();
                System.out.print(node1.name+" ");
                node=node1.rightNode;
            }
        }

    }

    //非层次递归----后序
    public static void postFor(Node node) {
        Stack<Node> stack = new Stack<>();
        Node pre = null,cur;
        stack.add(node);
        while (!stack.empty()){
            cur=stack.peek();
            if((cur.leftNode==null && cur.rightNode==null) || (pre!=null && (cur.leftNode==pre || cur.rightNode==pre)) ){
                System.out.print(cur.name);
                pre=stack.pop();
             }else{
                if(cur.rightNode!=null){
                    stack.add(cur.rightNode);
                }
                if(cur.leftNode!=null){
                    stack.add(cur.leftNode);
                }
            }
        }

    }


    public static void main(String[] args) {
        Node node4 = new Node("A");
        Node node6 = new Node("E");
        Node node8 = new Node("H");
        Node node9 = new Node("Z");

        Node node5 = new Node("F", node6, null);
        Node node2 = new Node("D", node4, node5);
        Node node3 = new Node("M", node8, node9);
        Node node1 = new Node("G", node2, node3);

        node1.leftNode = node2;
        node1.leftNode = node2;

//        System.out.println("----------前序------");
//        NodeTest.preDigui(node1);
//        System.out.println("----------中序------");
//        NodeTest.centerDigui(node1);
//        System.out.println("----------后序------");
//        NodeTest.postDigui(node1);
//        System.out.println("----------层次------");
//        NodeTest.allDigui(node1);
//        NodeTest.preFor(node1);
//        System.out.println("");
//        NodeTest.centerFor(node1);
        NodeTest.postFor(node1);

    }


    @Data
    static class Node {
        String name;
        Node leftNode;
        Node rightNode;

        public Node(String name) {
            this.name = name;
        }

        public Node(String name, Node leftNode, Node rightNode) {
            this.name = name;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }
}
