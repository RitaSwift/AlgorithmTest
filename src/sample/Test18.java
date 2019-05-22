package sample;

import java.util.List;

/**
 * ������18��ɾ������Ľڵ�
 * ��Ŀһ����o(1)ʱ����ɾ������Ľڵ�
 * �������������ͷָ���һ���ڵ�ָ�룬����һ��������o��1��ʱ����ɾ���ýڵ㡣����ڵ�ͺ����������£�
 *
 * ��Ŀ����ɾ���������ظ��Ľڵ㡣
 * ��һ������������У����ɾ���ظ��Ľڵ㣿
 */
public class Test18 {
    public static class ListNode{
        int key;
        ListNode next;
    }

    public static void main(String[] args) {
        //1.������м�ڵ�
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
            //todo ����ط����ж������ܽ���
            //1.���ɾ�������м�Ľڵ�
            if(deleteNode.next != null){
                ListNode next = deleteNode.next;
                deleteNode.key = next.key;
                deleteNode.next = next.next;
            }
            //2.�����β���ڵ�
            //todo ע����ߵ�����Ƿ����
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
            //3.�����ͷβ���ڵ�
            else {
                head = null;
                deleteNode = null;
            }
            //��ӡ�����еĽڵ�
            ListNode node = head;
            while(node != null){
                System.out.println(node.key);
                node = node.next;
            }
        }
    }

    /**
     * ��һ������������У����ɾ���ظ��Ľڵ㣿
     */
    public static void function2(ListNode head){
        /**
         * ������Ҫ����ÿ���ڵ����һ���ڵ�preNode��������һ�ظ���preNodeҪָ���ظ��ڵ����һ��
         * ���ֿ���������ǣ�
         * 1.ͷ���ɾ��
         * 2.�м�ڵ�ɾ��
         * 3.β���ڵ�ɾ��
         * 4.û���ظ��Ľڵ�
         * �����������:
         * 1.ͷ���Ϊnull
         * 2.���������еĽڵ㶼���ظ���
         */
        if(head == null)
            return;
        ListNode preNode = null;//��ǰ��ǰһ���ڵ�
        ListNode pNode = head;//��ǰ�Ľڵ�
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
                //�����Ҫɾ������ɾ�����ֵ�����нڵ�
                int value = pNode.key;
                ListNode pToBeDel = pNode;
                while(pToBeDel != null && pToBeDel.key == value){
                    //��¼��Ҫɾ���Ľڵ�ָ�뵽������
                    pNext = pToBeDel.next;
                    pToBeDel = pNext;
                }
                //���в��ظ���ָ��ĵ���
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
