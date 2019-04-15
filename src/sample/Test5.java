package sample;

import java.util.Stack;

/**
 * ������5����β��ͷ��ӡ����
 * ��Ŀ������һ�������ͷ��㣬��β��ͷ��������ӡ��ÿ������ֵ
 * ʹ��ջ�ṹ�Ϳ��Դ�ͷ��β��������β��ͷ��ӡ��
 */
public class Test5 {
    /**
     *�ӵ����
     */
    public static class ListNode{
        int key;
        ListNode nxt;
    }

    /**
     * ����ÿ�������ͷ��㣬��β��ͷ��������ӡ��ÿ������ֵ
     * ʹ��ջ�ķ�ʽ����,�ݹ����ջ����ʽ
     */
    public static void printReverse(ListNode head){
        if(head != null){
            if(head.nxt != null){
                printReverse(head.nxt);
            }
            //ע�� ����ط�Ӧ���Ǵ�ӡ��һ����ֵ
            System.out.println(head.key);
        }
    }

    /**
     * ���ֱ��ʹ��ջ��ӡ
     */
    public static void printReverseWithStack(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        //1.������ѹջ
        while(head != null){
            stack.push(head);
            head = head.nxt;
        }

        //��ջ����ӡ
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
