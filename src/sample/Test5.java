package sample;

import java.util.Stack;

/**
 * 面试题5：从尾到头打印链表
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值
 * 使用栈结构就可以从头到尾遍历，从尾到头打印了
 */
public class Test5 {
    /**
     *接点对象
     */
    public static class ListNode{
        int key;
        ListNode nxt;
    }

    /**
     * 输入每个链表的头结点，从尾到头反过来打印出每个结点的值
     * 使用栈的方式进行,递归就是栈的形式
     */
    public static void printReverse(ListNode head){
        if(head != null){
            if(head.nxt != null){
                printReverse(head.nxt);
            }
            //注意 这个地方应该是打印第一个的值
            System.out.println(head.key);
        }
    }

    /**
     * 如果直接使用栈打印
     */
    public static void printReverseWithStack(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        //1.将数据压栈
        while(head != null){
            stack.push(head);
            head = head.nxt;
        }

        //出栈并打印
        while(!stack.isEmpty()){
            System.out.println(stack.pop().key);
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        node1.key = 1;
        ListNode node2 = new ListNode();
        node2.key = 2;
        node1.nxt = node2;
        ListNode node3 = new ListNode();
        node3.key = 3;
        node2.nxt = node3;
        ListNode node4 = new ListNode();
        node4.key = 4;
        node3.nxt = node4;
        printReverse(node1);
        printReverseWithStack(node1);
    }
}
