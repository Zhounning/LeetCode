package leetCode;

public class detectCycle {
    public ListNode DetectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        // 使用快慢指针
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }

        // 说明存在环
        if (slow == fast) {
            slow = head;

            while (fast.next != slow) {
                slow = slow.next;
                fast = fast.next;
            }

        } else {
            return null;
        }

        return slow;
    }
}