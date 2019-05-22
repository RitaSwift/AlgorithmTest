package sample;

import java.util.List;

/**
 * 面试题18：删除链表的节点
 * 题目一：在o(1)时间内删除链表的节点
 * 给定单向链表的头指针和一个节点指针，定义一个函数在o（1）时间内删除该节点。链表节点和函数定义如下：
 *
 * 题目二：删除链表中重复的节点。
 * 在一个排序的链表中，如何删除重复的节点？
 */
public class Test18 {
    public static class ListNode{
        int key;
        ListNode next;
    }

    public static void main(String[] args) {
        //1.如果是中间节点
        ListNode node1 = new ListNode();
        node1.key = 4;
//        node1.next = null;
        ListNode node2 = new ListNode();
        node2.key = 2;
        node1.next = node2;
        ListNode node3 = new ListNode();
        node3.key = 2;
        node2.next = node3;
        ListNode node4 = new ListNode();
        node4.key = 1;
        node3.next = node4;
        node4.next = null;
//        function1(node1,node1);
        function2(node1);
    }

    public static void function1(ListNode head, ListNode deleteNode){
        if(head != null && deleteNode != null){
            //todo 这个地方的判断条件很讲究
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

    /**
     * 在一个排序的链表中，如何删除重复的节点？
     */
    public static void function2(ListNode head){
        /**
         * 分析：要保存每个节点的上一个节点preNode，这样万一重复，preNode要指向重复节点的下一个
         * 几种可能情况考虑：
         * 1.头结点删除
         * 2.中间节点删除
         * 3.尾部节点删除
         * 4.没有重复的节点
         * 特殊情况测试:
         * 1.头结点为null
         * 2.链表中所有的节点都是重复的
         */
        if(head == null)
            return;
        ListNode preNode = null;//当前的前一个节点
        ListNode pNode = head;//当前的节点
        while(pNode != null){
            ListNode pNext = pNode.next;
            boolean needDelete = false;
            if(pNext != null && pNext.key == pNode.key){
                needDelete = true;
            }

            if(!needDelete){
                preNode = pNode;
                pNode = pNode.next;
            }else{
                //如果需要删除就是删除这个值的所有节点
                int value = pNode.key;
                ListNode pToBeDel = pNode;
                while(pToBeDel != null && pToBeDel.key == value){
                    //记录需要删除的节点指针到哪里了
                    pNext = pToBeDel.next;
                    pToBeDel = pNext;
                }
                //进行不重复的指针的调整
                if(preNode == null){
                    head = pNext;
                }else{
                    preNode.next = pNext;
                }
                pNode = pNext;
            }
        }

        ListNode node = head;
        while(node != null){
            System.out.println(node.key);
            node = node.next;
        }
    }
}
