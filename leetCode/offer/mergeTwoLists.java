package leetCode.offer;

import java.util.List;

import leetCode.ListNode;

public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode h = dummy;

        while (l1!=null||l2!=null) {
            int p1 = l1==null ? Integer.MAX_VALUE : l1.val;
            int p2 = l2==null ? Integer.MAX_VALUE : l2.val;
            if (p1<p2) {
                h.next = l1;
                h = l1;
                l1 = l1.next;
            }else{
                h.next = l2;
                h = l2;
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}