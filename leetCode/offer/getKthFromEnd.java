package leetCode.offer;

import leetCode.ListNode;

public class getKthFromEnd {
    public ListNode GetKthFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        while (k > 0 && p1 != null) {
            p1 = p1.next;
            k--;
        }

        ListNode p2 = head;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}