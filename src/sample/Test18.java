package sample;

/**
 * ������18��ɾ������Ľڵ�
 * ��Ŀһ����o(1)ʱ����ɾ������Ľڵ�
 * �������������ͷָ���һ���ڵ�ָ�룬����һ��������o��1��ʱ����ɾ���ýڵ㡣����ڵ�ͺ����������£�
 */
public class Test18 {
    public static class ListNode{
        int key;
        ListNode next;
    }

    public static void main(String[] args) {
        //1.������м�ڵ�
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

    //todo ����ط����ж������ܽ���

}
