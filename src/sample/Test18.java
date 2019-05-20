package sample;

/**
 * 面试题18：删除链表的节点
 * 题目一：在o(1)时间内删除链表的节点
 * 给定单向链表的头指针和一个节点指针，定义一个函数在o（1）时间内删除该节点。链表节点和函数定义如下：
 */
public class Test18 {
    public static class ListNode{
        int key;
        ListNode next;
    }

    public static void main(String[] args) {
        //1.如果是中间节点
        ListNode node1 = new ListNode();
        node1.key = 1;
        node1.next = null;
//        ListNode node2 = new ListNode();
//        node2.key = 2;
//        node1.next = node2;
//        ListNode node3 = new ListNode();
//        node3.key = 3;
//        node2.next = node3;
//        ListNode node4 = new ListNode();
//        node4.key = 4;
//        node3.next = node4;
//        node4.next = null;
        function(node1,node1);
    }

    public static void function(ListNode head, ListNode deleteNode){
        if(head != null && deleteNode != null){
            //1.如果删除的是中间的节点
            if(deleteNode.next != null){
                ListNode next = deleteNode.next;
                deleteNode.key = next.key;
                deleteNode.next = next.next;
            }
            //2.如果是尾部节点
            //todo 注意这边的相等是否成立
            else if(deleteNode.next == null && deleteNode != head){
                ListNode node = head;
                while(node != null){
                    if(node.next == deleteNode){
                        node.next = null;
                    }else{
                        node = node.next;
                    }
                }
            }
            //3.如果是头尾部节点
            else {
                head = null;
                deleteNode = null;
            }
            //打印出所有的节点
            ListNode node = head;
            while(node != null){
                System.out.println(node.key);
                node = node.next;
            }
        }
    }

    //todo 这个地方的判断条件很讲究

}
