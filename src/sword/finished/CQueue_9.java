package sword.finished;


import java.util.Stack;

/**
 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof

 */


public class CQueue_9 {

    Stack<Integer> s1;
    Stack<Integer> s2;
    public CQueue_9() {
        s1=new Stack<>();
        s2=new Stack<>();
    }

    public void appendTail(int value) {
        while(s1.size()>0){
            s2.push(s1.pop());
        }
        s2.push(value);
        while(s2.size()>0){
            s1.push(s2.pop());
        }

    }

    public int deleteHead() {
        if(s1.size()==0 )return -1;
        return s1.pop();
    }

}



//没想到可以用题解的方式。。