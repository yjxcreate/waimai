package com.itheima.reggie.test;

//操作类
public class SingleLinkedList {
    //定义一个单链表
    public static LinkList linkList = new LinkList();
    //定义一个尾指针
    static Node rear = linkList.head;

    //头插法建表
    public static void CreateListF(Node node) {
        //申请新结点
        Node n = new Node();
        //数据域赋值
        n.setData(node.getData());
        //指针域赋值
        n.setNext(linkList.head);
        //头指针指向新结点
        linkList.head = n;
        //链表长度加1
        linkList.size++;
    }

    //尾插法建表
    public static void CreateListR(Node node) {
        //申请新结点
        Node n = new Node();
        //数据域赋值
        n.setData(node.getData());
        //判断链表是否为null，并插入新结点
        if (linkList.head == null) {
            linkList.head = n;
        } else rear.setNext(n);
        //尾指针指向新结点
        rear = n;
        //终端结点指针域置空
        if (rear.getNext() != null)
            rear.setNext(null);
        //链表长度加1
        linkList.size++;
    }

    //遍历
    public static void ListShow() {
        //定义一个新结点，用于循环赋值显示
        Node n = linkList.head;
        //循环链表
        for (int i = 0; i < linkList.size; i++) {
            //输出新结点的数据值
            System.out.println(n.getData());
            //新结点指向下一个结点
            n = n.getNext();
        }
    }

    //查找：按结点序号查找,返回该结点
    public static Node GetNodeI(int i) {
        //判断查找的序号是否合法
        if (i <= 0 || i > linkList.size) {
            System.out.println("position error!");
        }
        //定义一个新结点并赋值
        Node n = linkList.head;
        //序号无负数，从1开始
        for (int j = 1; j <= linkList.size; j++) {
            if (i == j) {
                break;
            }
            //新结点指向下一个结点
            n = n.getNext();
        }
        return n;
    }

    //查找：按结点值查找,参数为结点值
    public static Node GetNodeK(Object n) {
        //判断链表是否为空
        if (linkList.size == 0) {
            System.out.println("LinkList is null!");
        }
        //判断结点值是否与头结点相等
        if (n == linkList.head.getData()) {
            return linkList.head;
        }
        //定义一个新结点并赋值
        Node newNode = linkList.head;
        while (linkList.size > 0) {
            if (newNode.getData() == n) {
                return newNode;
            }
            //新结点指向下一个结点
            newNode = newNode.getNext();
            linkList.size--;
        }
        return null;
    }

    //插入：将值为x的新结点插入到第i个结点的位置上
    public static void InsertList(int i, Object x) {
        //判断插入的位置是否合法
        if (i <= 0 || i > linkList.size) {
            System.out.println("position error!");
        }
        //链表长度加1
        linkList.size++;
        int k = 1;
        //创建新结点并赋值
        Node p = linkList.head;
        //使p指向i-1个结点
        while (p != null && k < i - 1) {
            p = p.getNext();
            k++;
        }
        //申请一个新结点
        Node newNode = new Node();
        //数据域赋值
        newNode.setData(x);
        //指针域赋值
        newNode.setNext(p.getNext());
        //i-1个结点指向新节点
        p.setNext(newNode);
    }

    //删除：将链表中的第i个结点删除,并返回该值
    public static Object DeleteList(int i) {
        //判断要删除的位置是否合法
        if (i <= 0 || i > linkList.size) {
            System.out.println("position error!");
        }
        int n = 1;
        //创建新结点并赋值
        Node p = linkList.head;
        //使p指向i-1个结点
        while (p != null && n < i - 1) {
            p = p.getNext();
            n++;
        }
        //定义一个新结点,指向第i个结点
        Node s = p.getNext();
        //使p的下一个结点指向i+1个结点
        p.setNext(s.getNext());
        //保存被删除结点的值
        Object x = s.getData();
        linkList.size--;
        return x;
    }
}
