import com.itheima.reggie.test.Node;
import com.itheima.reggie.test.SingleLinkedList;

public class SingleLinkedListTest {
//    public static void main(String[] args) {
//
//
//        //创建结点值
//        Node n1 = new Node("qq", null);
//        Node n2 = new Node("ww", null);
//        Node n3 = new Node("ee", null);
//        Node n4 = new Node("rr", null);
//        //头插法
//        SingleLinkedList.CreateListF(n1);
//        SingleLinkedList.CreateListF(n2);
//        SingleLinkedList.CreateListF(n3);
//        SingleLinkedList.CreateListF(n4);
//
//        System.out.println(SingleLinkedList.linkList);
//    }

    public static void main(String[] args) {
        //创建结点值
        Node n1 = new Node("qq", null);
        Node n2 = new Node("ww", null);
        Node n3 = new Node("ee", null);
        Node n4 = new Node("rr", null);
        //尾插法
        SingleLinkedList.CreateListR(n1);
        SingleLinkedList.CreateListR(n2);
        SingleLinkedList.CreateListR(n3);
        SingleLinkedList.CreateListR(n4);

        System.out.println(SingleLinkedList.linkList);

        System.out.println(SingleLinkedList.linkList);
        System.out.println("---------------------------------");

        //遍历
        System.out.println("链表元素遍历为：");
        SingleLinkedList.ListShow();
        System.out.println("---------------------------------");

        //查找：按结点序号
        Node node = SingleLinkedList.GetNodeI(1);
        System.out.println("结点序号为1的元素值为：" + node.getData());
        System.out.println("---------------------------------");

        //查找：按结点值查找
        Node node1 = SingleLinkedList.GetNodeK("ww");
        System.out.println("元素值是‘ww’的结点为：" + node1);
        System.out.println("---------------------------------");


    }


}
