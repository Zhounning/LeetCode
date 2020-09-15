package leetCode.offer;

import java.util.Stack;

public class CQueue {

    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    public CQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void appendTail(int value) {
        pushStack.add(value);
    }

    public int deleteHead() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.add(pushStack.pop());
            }

        }
        
        if (popStack.isEmpty()) {
            return -1;
        }
        return popStack.pop();
    }

}