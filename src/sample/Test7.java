package sample;

import java.util.Stack;

/**
 * ������7;������ջʵ�ֶ���
 * ��Ŀ��������ջʵ�ֶ��С����е��������£�
 * ��ʵ��������������appendTail��deleteHead��
 * �ֱ�����ڶ���β������ڵ���ڶ���ͷ��ɾ���ڵ�Ĺ���
 */
public class Test7 {
    public static class CQueue{
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();
        //�������ǲ���һ�� ����һ�� ����һ�� ɾ��һ������˳�򲻻��
        public void appendTail(int key){
            //���stack1Ϊ�գ���ֱ��push����
            //���stack1��Ϊ�գ���pop������stack2�����еģ���push����
            if(stack1.isEmpty()){
                stack1.push(key);
            }else{
                stack1.push(key);
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
        }

        public int deleteHead(){
            //���stack2��Ϊ�գ�ֱ��pop
            //���stack2Ϊ�գ�ȥ���stack1�����ݵ�stack2������pop()stack2�ĵ�һ������
            if(!stack2.isEmpty()){
                return stack2.pop();
            }else{
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(3);
        cQueue.appendTail(4);
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(6);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}
