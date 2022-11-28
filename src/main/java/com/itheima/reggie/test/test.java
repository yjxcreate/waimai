package com.itheima.reggie.test;

public class test {
    public static void main(String[] args) {
        linkString link = new linkString(1,new linkString.Node('1'));
        link.insert('2');
        link.insert('3');
        link.insert('4');
        link.insert('5');
        System.out.println(link.length());
        System.out.println(link.isEmpty());
        link.printf();
        System.out.println("========================================");
        link.insert(2,'b');
        link.insert(6,'6');
        link.insert(8,'8');
        link.printf();

        linkString test = new linkString(1,new linkString.Node('1'));
        test.insert('2');
        test.insert('3');
        test.insert('4');
        test.insert('5');
        test.printf();
        System.out.println(link.get(8));

        System.out.println("========================================");
        link.insert(4,test).printf();

        System.out.println("========================================");
        System.out.println(link.get(8));
        link.clear();
        System.out.println(link.length());
        System.out.println(link.isEmpty());
        link.printf();

    }
}