package com.itheima.reggie.test;


//链表类
public class LinkList {
    //头结点
    Node head;
    //链表长度
    int size;

    //构造方法
    public LinkList() {
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        return "LinkList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }
}
