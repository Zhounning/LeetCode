package leetCode.offer;

import leetCode.ListNode;

/**
 * deleteNode
 */
public class deleteNode {
    public ListNode DeleteNode(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p != null && p.next != null && p.next.val != val) {
            p = p.next;
        }
        if (p != null && p.next != null && p.next.val == val) {
            ListNode q = p.next;
            p.next = p.next.next;
            q.next = null;
        }
        return dummy.next;
    }

}