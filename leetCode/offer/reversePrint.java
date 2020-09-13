package leetCode.offer;

import java.util.Stack;

import leetCode.ListNode;

public class reversePrint {
    public int[] ReversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        int n = 0;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
            n++;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}