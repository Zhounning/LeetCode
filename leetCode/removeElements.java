package leetCode;

public class removeElements {
    public ListNode RemoveElements(ListNode head, int val) {
        // 哑节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            while (cur != null && cur.val != val) {
                pre = pre.next;
                cur = cur.next;
            }

            // 说明找到这个节点
            if (cur != null) {
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
            }
        }

        return dummy.next;
    }
}