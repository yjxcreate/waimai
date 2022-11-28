package com.itheima.reggie.test;

public class linkString  {
    private Node head = null;       //定义头节点
    private int N;           //定义链串的长度


    //节点类
    static class Node {
        public char value; //数据域 存放数据
        public Node next;    //指针域,指向下一个节点


        //内部类的构造器 用于创建新节点
        public Node(char value) {
            this.value = value;
        }

    }


    //LinkString类的构造器  创建LinkString对象
    public linkString(int N, Node head) {
        this.N = N;
        this.head = head;
    }

    //清空链串
    public void clear() {
        this.head = null;    //将头节点指空
    }


    //判断串是否为空
    public boolean isEmpty() {
        return this.head == null; //判断头结点是否为空
    }

    //获取串中元素的个数
    public int length() {
        int count = 0;
        Node moveNode = this.head;
        while (moveNode != null) {       //通过循环遍历来计算元素的个数
            count++;
            moveNode = moveNode.next;
        }
        return count;
    }


    //读取并返回串中位序号为i的元素的值
    public char get(int i) {
        Node moveNode = this.head;
        if (i > this.length() + 1) {
            System.out.println("序号i超过链串的最大长度");
            return 0;
        }
        for (int count = 1; count < i; count++) {

            moveNode = moveNode.next;
        }
        return moveNode.value;
    }


    //向串中添加一个元素t
    //尾插法 且头节点不为空
    public void insert(char t) {
        Node moveNode = this.head;
        Node newNode = new Node(t);
        while (moveNode.next != null) {    //通过遍历拿到最后一个结点
            moveNode = moveNode.next;
        }
        moveNode.next = newNode;           //将新结点插入链表
        this.N++;                          //链表长度加1
        System.out.println("添加成功");
    }


    //在串中位序号为i的元素之前插入一个值为t的数据元素
    public void insert(int i, char t) {
        Node moveNode = this.head;      //将moveNode指向头结点
        Node preNode = this.head;       //将preNode指向头结点
        Node newNode = new Node(t);     //创建一个新结点

        if (i > this.length() + 1) {     //如果序号i超过链串的最大长度,则添加失败
            System.out.println("序号i超过链串的最大长度");
            return;
        }

        for (int count = 1; count < i; count++) {  //通过循环找到序号为i的结点;
            preNode = moveNode;                     //记录当前结点  循环结束后preNode指向序号为i的前一个结点
            moveNode = moveNode.next;               //把当前结点移向下一个结点   循环结束后moveNode指向序号为i的结点
        }

        preNode.next = newNode;                       //将新结点插入链串
        newNode.next = moveNode;
        this.N++;                                     //链表长度加1
        System.out.println("插入成功");
    }

    //在串中位序号为i的元素之前插入一个值为t的子串，并返回
    public linkString insert(int i, linkString t) {
        Node moveNode = this.head;
        Node tailNode = this.head;
        Node preNode = this.head;
        try {
            if (i > this.length() + 1) {
                int a = 1 / 0;
            }
        } catch (Exception e) {
            throw new RuntimeException("序号i超过链串的最大长度");
        }

        for (int count = 0; count < i; count++) {
            preNode = moveNode;
            moveNode = moveNode.next;
        }
        tailNode = moveNode;
        moveNode = t.head;
        while (moveNode.next != null) {
            moveNode = moveNode.next;
        }
        preNode.next = t.head;
        moveNode.next = tailNode;
        this.N  = this.N + t.N;
        return this;

    }

    //打印链串
    public void printf() {
        Node moveNode = this.head;   //将moveNode指向头节点
        System.out.println("链表长度:" + this.N);
        while (moveNode != null)        //当前结点不为空则循环继续
        {
            System.out.println(moveNode.value);  //打印当前结点的值
            moveNode = moveNode.next;            //把当前结点移向下一个结点
        }
    }

}
