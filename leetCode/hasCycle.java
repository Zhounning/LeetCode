package leetCode;

public class hasCycle {
    public boolean HasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        // 使用快慢指针
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }

        return slow == fast;
    }
}