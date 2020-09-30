package leetCode.offer;

import java.util.ArrayDeque;

public class MaxQueue {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    ArrayDeque<Integer> maxQueue = new ArrayDeque<>();

    public MaxQueue() {

    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.addLast(value);
        if (maxQueue.isEmpty() || maxQueue.peekLast() >= value) {
            maxQueue.addLast(value);
        } else {
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
                maxQueue.pollLast();
            }
            maxQueue.addLast(value);
        }
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int v = queue.pollFirst();
        if (maxQueue.peekFirst() == v) {
            maxQueue.pollFirst();
        }

        return v;
    }
}