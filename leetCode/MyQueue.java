package leetCode;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    int top;

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.empty())
            top = x;
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        stack2.push(x);
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int res = stack1.pop();
        if (!stack1.empty())
            top = stack1.peek();
        return res;
    }

    /** Get the front element. */
    public int peek() {
        return top;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.peek(); // 返回 1
        queue.empty(); // 返回 false
    }
}