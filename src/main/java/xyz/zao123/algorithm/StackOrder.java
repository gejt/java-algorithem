package xyz.zao123.algorithm;

import java.util.Stack;

/**
 * 第一个序列表示栈的压栈顺序，请判断第二个序列是否为该栈的弹出顺序
 * 假设压入栈的顺序均不重复
 */
public class StackOrder {

    public static void main(String[] args) {
        
        int[] num = {1,2,3,4,5};
        int[] num1={1,2,3,5,4};
        int[] num2={2,1,5,3,4};
        int[] num3 = {2,1,5,4,3};

        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        for(int i=4;i>=0;i--){
            s2.push(num3[i]);
        }

        System.out.println(testOrder(num,s1,s2));
    }

    private static boolean testOrder(int[] num, Stack<Integer> s1, Stack<Integer> s2) {
        int length = num.length;
        for(int i=0;i<length;i++){
            s1.push(num[i]);
            while(!s1.isEmpty() && s2.lastElement().intValue()==s1.lastElement().intValue()){
                s1.pop();
                s2.pop();
            }
        }
        if(!s1.isEmpty()){return false;
        }
        return true;
    }

}
