package xyz.zao123.algorithm;

import java.util.Stack;

/**
 * 定义栈的数据结构，实现一个能够得到栈的最小元素的min方法，
 * 在该栈中调用 min  push  pop 的时间 复杂度都为O(n)
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        System.out.println(ms.min());
        ms.push(6);
        ms.push(2);
        ms.push(1);
        System.out.println(ms.min());
        ms.pop();
        System.out.println(ms.min());
        ms.pop();
        System.out.println(ms.min());
    }

    private Stack<Integer> minStack = new Stack<Integer>();
    private Stack<Integer> stack = new Stack<Integer>();

    public int pop(){
        minStack.pop();
        return stack.pop();
    }

    public void push(int num){
        if(minStack.size()<=0){
            minStack.push(num);
            return;
        }
        Integer min = minStack.lastElement();
        if(num<min){
            minStack.push(num);
        }
        else{
            minStack.push(min);
        }
        stack.push(num);
    }

    public int min(){
        if(minStack.size()<=0){
            return -1;
        }
        return minStack.lastElement();
    }
}
