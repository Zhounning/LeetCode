package leetCode;

/**
 * reorderList 思路上直接使用栈是可以实现的 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 给定链表
 * 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class reorderList {

    public void ReorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 使用快慢指针
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 遍历完之后slow就在中点
        ListNode p_head = reverseList(slow.next);
        slow.next = null;

        ListNode cur = head;
        while (cur != null && p_head != null) {
            ListNode curnext = p_head;
            p_head = p_head.next;
            curnext.next = cur.next;
            cur.next = curnext;
            cur = cur.next.next;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode lastNode = null;
        ListNode nextNode = null;

        while (cur != null) {
            nextNode = cur.next;
            cur.next = lastNode;
            lastNode = cur;
            cur = nextNode;
        }

        return lastNode;
    }
}