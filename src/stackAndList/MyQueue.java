package stackAndList;

import java.util.Stack;

/**
 * 1）如何用栈结构实现队列结构
 * 思路：
 * push栈 和 pop栈 (1. 一次性倒完push栈数据；2. pop没拿完不能倒数据【pop空了才能倒数据】)
 *                                               👆反正是队列所以不碍事
 *
 * 2）如何用队列结构实现栈结构
 * 思路：
 * 两个队列，存入数据12345到队列A >54321>，需要取5，那么把1234存入到队列B >4321>，留下5再取出5.
 * 再添加数据678在队列B >8764321> ，需要取8，那么把123467存入到队列A >764321> ，留下8再取出8.
 */
class MyQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public MyQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    public void push(int x) {

    }

    public int pop() {
        return 0;
    }

    public int peek() {
        return 0;
    }

    public boolean empty() {
        return false;
    }
}



