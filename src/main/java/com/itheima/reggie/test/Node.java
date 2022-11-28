package com.itheima.reggie.test;

//链表结点类
public class Node {
    //数据域
    private Object data;
    //指针域
    private Node next;

    public Node() {
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "\nNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
