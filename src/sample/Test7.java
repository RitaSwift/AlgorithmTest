package sample;

import java.util.Stack;

/**
 * 面试题7;用两个栈实现队列
 * 题目：用两个栈实现队列。队列的声明如下，
 * 请实现它的两个函数appendTail和deleteHead。
 * 分别完成在队列尾部插入节点和在队列头部删除节点的功能
 */
public class Test7 {
    public static class CQueue{
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();
        //讲究的是插入一个 插入一个 插入一个 删除一个这种顺序不会错
        public void appendTail(int key){
            //如果stack1为空，则直接push进入
            //如果stack1不为空，则pop（）进stack2中所有的，在push进入
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
            //如果stack2不为空，直接pop
            //如果stack2为空，去清空stack1的数据到stack2，并且pop()stack2的第一个数据
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
